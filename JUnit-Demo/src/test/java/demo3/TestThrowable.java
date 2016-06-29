package demo3;

import org.junit.Test;

public class TestThrowable {

	/* permet de vérifier qu'un Throwable Exception a bien été déclenché  
	 */
	
	
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
}


