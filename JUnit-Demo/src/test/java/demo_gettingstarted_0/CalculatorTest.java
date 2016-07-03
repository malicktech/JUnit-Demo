package demo_gettingstarted_0;

import static org.junit.Assert.*;

import org.junit.Test;

import demo_gettingstarted_0.Calculator;

public class CalculatorTest {

	@Test
	public void evaluateAdditionExpression() {

		// THREE steps : Given When Then

		/* 1. Given : initialise l��tat du syst�me */
		Calculator calculator = new Calculator();

		// Expression exp = new ArithmeticExpression("1+2+3");
		// int sum = calculator.evaluate(exp);

		/* 2. When : appel de la m�thode test�e */
		int sum = calculator.evaluate("1+2+3");

		/* 3. Then : v�rifications du r�sultat */
		assertEquals(6, sum);
	}

}
