package demo3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAvantApresEnsemble {
	/*
	 * Préparation avant et démontage après l'ensemble de tests d'un cas de
	 * tests
	 * ========================================================================
	 * Ces annotations permettent d'indiquer une méthode qui sera exécutée avant
	 * l'ensemble des tests d'un cas de tests et une méthode qui sera exécutée
	 * après l'ensemble des tests d'un cas de tests.
	 */
	
	@BeforeClass
    public static void avantTests() {
        System.out.println("------------------------");
        System.out.println("Avant Tests");
        System.out.println("------------------------");
    }
    
    @AfterClass
    public static void apresTests() {
        System.out.println("------------------------");
        System.out.println("Après Tests");
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
