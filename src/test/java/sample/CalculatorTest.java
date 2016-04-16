package sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test   
	public void evaluateAdditionExpression() {
			Calculator calculator = new Calculator();
			Expression exp = new ArithmeticExpression("1+2+3");
			int sum = calculator.evaluate(exp);
			assertEquals(6, sum);
		}
	
	
}
