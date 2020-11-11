import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoffeeDecoratorTest {
	Coffee order;

	@BeforeEach
	public void init(){
		order =  new BasicCoffee();
	}
	@Test
	void firstTest() {
		assertNotNull(order, "Default order cannot be null");
	}
	@Test
	void secondTest(){
		order = new ExtraShot(order);
		assertEquals(5.19,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");
	}
	@Test
	void thirdTest(){
		order = new ExtraShot(new Cream(order));
		assertEquals(5.69,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");
	}
	@Test
	void fourthTest(){
		order = new ExtraShot(new Cream(new Vanilla(order)));
		assertEquals(6.69,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");
	}

	@Test
	void fifthTest(){
		order =  new Vanilla(new Vanilla(new Vanilla(order)));
		assertEquals(6.99,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");
	}
	@Test
	void sixthTest(){
		order =  new Sugar(new Sugar(new Sugar(new Sugar(new Sugar(new Sugar(order))))));
		assertEquals(6.99,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");
	}
	@Test
	void seventhTest(){
		order =  new ExtraShot(new Sugar(new Cream(order)));
		assertEquals(6.19,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");
	}

	@Test
	void eightTest(){
		order =  new Caramel(new Sugar(new Caramel(new Cream( new ExtraShot(order)))));
		assertEquals(8.19,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");
	}

	@Test
	void ninthTest(){
		order =  new Vanilla(new Caramel(new Sugar(new Caramel(new Cream( new ExtraShot(order))))));
		assertEquals(9.19,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");

	}
	@Test
	void tenthTest(){
		order =  new ExtraShot(new Sugar(new Sugar(new Caramel(new Cream( new Vanilla(order))))));
		assertEquals(8.69,Math.round(order.makeCoffee()*100.0)/100.0,"incorrect order total");
	}
}
