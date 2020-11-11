import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class OrderController implements EventHandler {
    VBox shopMenu;
    Stage primaryStage;
    Scene welcomeScene;
    HBox menuColumns;
    VBox menuGrid;
    Button extraShot;
    Button cream;
    Button sugar;
    Button vanilla;
    Button caramel;
    Text shotQty, creamQty, sugarQty, vanillaQty, caramelQty;
    HBox controls;
    Button orderBtn;
    Button clearBtn;
    Alert orderSummary;
    ArrayList<Integer> quantities = new ArrayList<>();
    protected Coffee order;


    public OrderController(VBox shopMenu, Stage primaryStage, Scene welcomeScene){
        this.order = new BasicCoffee();
        this.shopMenu = shopMenu;
        this.primaryStage = primaryStage;
        this.welcomeScene = welcomeScene;
        shopMenu.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));

        HBox menuItem =  new HBox();
        Text menuLabel = new Text();
        menuLabel.setText("Black Coffee");
        menuLabel.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 40));
        menuLabel.setFill(Color.BEIGE);
        menuLabel.setStrokeWidth(1);
        menuLabel.setStroke(Color.BLUEVIOLET);
        menuLabel.setTextAlignment(TextAlignment.CENTER);
        menuLabel.setUnderline(true);
        menuItem.getChildren().add(menuLabel);
        menuItem.setAlignment(Pos.CENTER);

        menuColumns = new HBox();
        menuColumns.setAlignment(Pos.CENTER);
        createMenuColumns();

        menuGrid = new VBox();
        createMenuGrid();

        controls =  new HBox();
        controls.setAlignment(Pos.CENTER);
        createOrderControls();

        shopMenu.getChildren().addAll(menuItem,menuColumns,menuGrid,controls);
        shopMenu.setSpacing(20);
        initialize();


    }

    public void createMenuColumns(){
        Text quantityTxt = new Text();
        quantityTxt.setText("Quantity");
        quantityTxt.setFont(Font.font("arial", FontWeight.MEDIUM, FontPosture.ITALIC, 20));
        quantityTxt.setFill(Color.BLACK);
        quantityTxt.setTextAlignment(TextAlignment.CENTER);
        Text addOns = new Text();
        addOns.setText("Additional Items");
        addOns.setFont(Font.font("arial", FontWeight.MEDIUM, FontPosture.ITALIC, 20));
        addOns.setFill(Color.BLACK);
        addOns.setTextAlignment(TextAlignment.CENTER);

        menuColumns.getChildren().addAll( addOns,quantityTxt);
        menuColumns.setSpacing(50);
    }

    public void createMenuGrid() {
        HBox row1 = new HBox(), row2 = new HBox(), row3 = new HBox(), row4 = new HBox(), row5 = new HBox();
        CornerRadii corner = new CornerRadii(20);

        shotQty = new Text("0");
        shotQty.setFont(Font.font("arial", FontWeight.MEDIUM, FontPosture.ITALIC, 20));
        shotQty.setFill(Color.BLACK);
        shotQty.setTextAlignment(TextAlignment.CENTER);
        extraShot = new Button("Extra shot");
        extraShot.setPrefSize(120,50);
        extraShot.setAlignment(Pos.CENTER);
        extraShot.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, corner, Insets.EMPTY)));
        extraShot.setBorder(Border.EMPTY);
        extraShot.setStyle("-fx-font: 20 arial;");
        row1.setSpacing(80);
        row1.getChildren().addAll(extraShot,shotQty);

        creamQty = new Text("0");
        creamQty.setFont(Font.font("arial", FontWeight.MEDIUM, FontPosture.ITALIC, 20));
        creamQty.setFill(Color.BLACK);
        creamQty.setTextAlignment(TextAlignment.CENTER);
        cream = new Button("Cream");
        cream.setPrefSize(120,50);
        cream.setAlignment(Pos.CENTER);
        cream.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, corner, Insets.EMPTY)));
        cream.setBorder(Border.EMPTY);
        cream.setStyle("-fx-font: 20 arial;");
        row2.setSpacing(80);
        row2.getChildren().addAll(cream,creamQty);

        sugarQty = new Text("0");
        sugarQty.setFont(Font.font("arial", FontWeight.MEDIUM, FontPosture.ITALIC, 20));
        sugarQty.setFill(Color.BLACK);
        sugarQty.setTextAlignment(TextAlignment.CENTER);
        sugar = new Button("Sugar");
        sugar.setPrefSize(120,50);
        sugar.setAlignment(Pos.CENTER);
        sugar.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, corner, Insets.EMPTY)));
        sugar.setBorder(Border.EMPTY);
        sugar.setStyle("-fx-font: 20 arial;");
        row3.setSpacing(80);
        row3.getChildren().addAll(sugar, sugarQty);

        vanillaQty = new Text("0");
        vanillaQty.setFont(Font.font("arial", FontWeight.MEDIUM, FontPosture.ITALIC, 20));
        vanillaQty.setFill(Color.BLACK);
        vanillaQty.setTextAlignment(TextAlignment.CENTER);
        vanilla = new Button("Vanilla");
        vanilla.setPrefSize(120,50);
        vanilla.setAlignment(Pos.CENTER);
        vanilla.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, corner, Insets.EMPTY)));
        vanilla.setBorder(Border.EMPTY);
        vanilla.setStyle("-fx-font: 20 arial;");
        row4.setSpacing(80);
        row4.getChildren().addAll(vanilla, vanillaQty);

        caramelQty = new Text("0");
        caramelQty.setFont(Font.font("arial", FontWeight.MEDIUM, FontPosture.ITALIC, 20));
        caramelQty.setFill(Color.BLACK);
        caramelQty.setTextAlignment(TextAlignment.CENTER);
        caramel = new Button("Caramel");
        caramel.setPrefSize(120,50);
        caramel.setAlignment(Pos.CENTER);
        caramel.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, corner, Insets.EMPTY)));
        caramel.setBorder(Border.EMPTY);
        caramel.setStyle("-fx-font: 20 arial;");
        row5.setSpacing(80);
        row5.getChildren().addAll(caramel, caramelQty);
        extraShot.setOnAction(this);
        cream.setOnAction(this);
        sugar.setOnAction(this);
        vanilla.setOnAction(this);
        caramel.setOnAction(this);
        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        row3.setAlignment(Pos.CENTER);
        row4.setAlignment(Pos.CENTER);
        row5.setAlignment(Pos.CENTER);
        menuGrid.getChildren().addAll(row1,row2,row3,row4,row5);
        menuGrid.setSpacing(25);
    }
    public  void createOrderControls(){

        orderBtn = new Button("Order now!");
        clearBtn = new Button("Clear Order");
        orderBtn.setOnAction(this);
        clearBtn.setOnAction(this);
        CornerRadii corner = new CornerRadii(10);

        orderBtn.setPrefSize(160,50);
        orderBtn.setAlignment(Pos.CENTER);
        orderBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, corner, Insets.EMPTY)));
        orderBtn.setBorder(new Border(new BorderStroke(Color.BLUEVIOLET,BorderStrokeStyle.SOLID, corner, new BorderWidths(4,4,4,4))));
        orderBtn.setStyle("-fx-font: 20 arial;");

        clearBtn.setPrefSize(160,50);
        clearBtn.setAlignment(Pos.CENTER);
        clearBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, corner, Insets.EMPTY)));
        clearBtn.setBorder(new Border(new BorderStroke(Color.BLUEVIOLET,BorderStrokeStyle.SOLID, corner, new BorderWidths(4,4,4,4))));
        clearBtn.setStyle("-fx-font: 20 arial;");

        controls.getChildren().addAll(orderBtn,clearBtn);
        controls.setSpacing(100);

    }

    public void initialize(){
        for(int i=0; i<5;i++){
            quantities.add(i,0);
        }

        shotQty.setText(Integer.toString(quantities.get(0)));
        creamQty.setText(Integer.toString(quantities.get(1)));
        sugarQty.setText(Integer.toString(quantities.get(2)));
        vanillaQty.setText(Integer.toString(quantities.get(3)));
        caramelQty.setText(Integer.toString(quantities.get(4)));
    }


    public double orderTotal(Coffee order){
        double cost = Math.round(order.makeCoffee()*100.0)/100.0;
        System.out.println("Total: "+cost);
        return cost;
    }


    public void displayOrder(Coffee order){

        String orderDetails = "Black Coffee: $3.99\n" ;
        orderSummary = new Alert(Alert.AlertType.CONFIRMATION);
        orderSummary.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        orderSummary.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
        orderSummary.setTitle("Yay! Your Order is complete!");
        orderSummary.setHeaderText("--Order Summary--");

        for(int i =0; i< quantities.size(); i++){
            for(int j =0; j <quantities.get(i); j++){
                if(i ==0){
                    orderDetails += " + extra shot: $1.20\n";
                }
                if(i == 1){
                    orderDetails += " + cream: $.50\n";
                }
                if(i ==2){
                    orderDetails += " + sugar: $.50\n";
                }
                if(i ==3){
                    orderDetails += " + vanilla: $1.00\n";
                }
                if(i ==4){
                    orderDetails += " + caramel: $1.00\n";
                }
            }
        }
        orderDetails += "Total: $";
        orderDetails += Double.toString(orderTotal(order));
        orderSummary.setContentText(orderDetails);
        orderSummary.setOnCloseRequest(this);
        orderSummary.showAndWait();
    }

    @Override
    public void handle(Event event) {

        if (event.getSource() == extraShot){
            quantities.set(0, quantities.get(0) + 1);
            shotQty.setText(Integer.toString(quantities.get(0) ));
            System.out.println("shots: "+ quantities.get(0));
            order = new ExtraShot(order);
            order.makeCoffee();

        }

        if (event.getSource() == cream){
            quantities.set(1, quantities.get(1) + 1);
            creamQty.setText(Integer.toString(quantities.get(1) ));
            System.out.println("cream: "+ quantities.get(1));
            order = new Cream(order);
            order.makeCoffee();

        }
        if (event.getSource() == sugar){
            quantities.set(2, quantities.get(2) + 1);
            sugarQty.setText(Integer.toString(quantities.get(2) ));
            System.out.println("sugar: "+ quantities.get(2));
            order = new Sugar(order);
            order.makeCoffee();

        }
        if (event.getSource() == vanilla){
            quantities.set(3, quantities.get(3) + 1);
            vanillaQty.setText(Integer.toString(quantities.get(3) ));
            System.out.println("vanilla: "+ quantities.get(3));
            order = new Vanilla(order);
            order.makeCoffee();
        }
        if (event.getSource() == caramel){
            quantities.set(4, quantities.get(4) + 1);
            caramelQty.setText(Integer.toString(quantities.get(4) ));
            System.out.println("caramel: "+ quantities.get(4));
            order = new Caramel(order);
            order.makeCoffee();

        }
        if(event.getSource().equals(orderBtn)){
            displayOrder(order);
        }
        if(event.getSource().equals(clearBtn)){
            System.out.println("Clearing order");
            this.order = new BasicCoffee();
            quantities.clear();
            initialize();
        }
        if(event.getSource().equals(orderSummary)){
            primaryStage.setScene(welcomeScene);
        }

    }
}
