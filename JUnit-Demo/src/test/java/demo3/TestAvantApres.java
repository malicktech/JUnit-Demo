package demo3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAvantApres {

	/*
	 *  Préparation avant et démontage après chaque test d'un cas de test.
	 *  Ces annotations permettent d'indiquer une méthode qui sera exécutée avant
	 * chaque test et un méthode qui sera exécutée après chaque test.
	 */

	@Before
	public void avantTest() {
		System.out.println("------------------------");
		System.out.println("Avant Test");
	}

	@After
	public void apresTest() {
		System.out.println("Après Test");
		System.out.println("------------------------");
	}

	@Test
	public void premierTest() {
		System.out.println("Premier Test");
	}

	@Test
	public void deuxiemeTest() {
		System.out.println("Deuxième Test");
	}

	@Test
	public void troisiemeTest() {
		System.out.println("Troisième Test");
	}
}
