import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoffeeShop extends Application implements EventHandler {

	Stage primaryStage;
	Scene welcomeScene;
	VBox parent;
	Button placeOrder;
	VBox newParent;
	OrderController coffeeMenu;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		parent = new VBox();
		Text shopName = new Text();
		shopName.setText("COZMO \nCOFFEE SHOP");
		shopName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		shopName.setFill(Color.YELLOWGREEN);
		shopName.setStrokeWidth(2);
		shopName.setStroke(Color.BLUEVIOLET);

		placeOrder = new Button();
		placeOrder.setText("New Order!");
		placeOrder.setPrefSize(200,80);
		placeOrder.setAlignment(Pos.CENTER);
		placeOrder.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		placeOrder.setBorder(Border.EMPTY);
		placeOrder.setStyle("-fx-font: 28 arial;");
		placeOrder.setOnAction(this);
		parent.setPadding(new Insets(50,100,0,100));
		parent.getChildren().addAll(shopName,placeOrder);
		parent.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));
		welcomeScene = new Scene(parent,600, 600);
		primaryStage.setScene(welcomeScene);
		primaryStage.show();

		primaryStage.setTitle("Welcome to Cozmo Coffee Shop");

	}

	@Override
	public void handle(Event event) {

		if (event.getSource() == placeOrder ){
			newParent = new VBox();
			coffeeMenu = new OrderController(newParent, primaryStage, welcomeScene);

			primaryStage.setScene(new Scene(newParent,600,600));
		}
	}
}
