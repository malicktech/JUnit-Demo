package demo3;

import org.junit.Assert;
import org.junit.Test;

public class TestOperations {

	/*  Test simple */
	
    @Test
    public void additionAvecDeuxNombres() {
        final long lAddition = Operations.additionner(10, 20);
        Assert.assertEquals(30, lAddition);
    }

    @Test
    public void additionAvecCinqNombres() {
        final long lAddition = Operations.additionner(256, 512, 1024, 2048, 4096);
        Assert.assertEquals(7936, lAddition);
    }

    @Test
    public void mutiplicationAvecDeuxNombres() {
        final long lMultiplication = Operations.multiplier(10, 20);
        Assert.assertEquals(300, lMultiplication);
    }
    
    public void testMutiplicationAvecCinqNombres() {
        final long lMultiplication = Operations.additionner(256, 512, 1024, 2048, 4096);
        Assert.assertEquals(1125899906842624L, lMultiplication);
    }
    
    /* Test devant déclencher un Throwable exception */
    
    @Test(expected=IllegalArgumentException.class)
    public void divisionAvecUnNombre() {
        Operations.diviser(1);
    }

    @Test(expected=ArithmeticException.class)
    public void divisionAvecDeuxNombresDontUnZero() {
        Operations.diviser(10, 0);
    }

    @Test(expected=ArithmeticException.class)
    public void divisionAvecDeuxNombres() {
        Operations.diviser(10, 5);
    }
    
    
    @Test(timeout=1000)
    public void dureeRespectee() {
        
    }

    @Test(timeout=1000)
    public void dureeNonRespectee() throws InterruptedException {
        Thread.sleep(10000);
    }
    
    /* Indisponibilité d'un test */
    
    
}