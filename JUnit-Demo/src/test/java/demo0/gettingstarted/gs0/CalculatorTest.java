package demo0.gettingstarted.gs0;

import static org.junit.Assert.*;

import org.junit.Test;

import demo0.gettingstarted.gs0.Calculator;

public class CalculatorTest {

	@Test
	public void evaluateAdditionExpression() {

		// THREE steps : Given When Then

		/* 1. Given : initialise l’état du système */
		Calculator calculator = new Calculator();

		// Expression exp = new ArithmeticExpression("1+2+3");
		// int sum = calculator.evaluate(exp);

		/* 2. When : appel de la méthode testée */
		int sum = calculator.evaluate("1+2+3");

		/* 3. Then : vérifications du résultat */
		assertEquals(6, sum);
	}

}
