package demo8_easymock_calculator.math;

import static org.junit.Assert.*;
import org.junit.Test;

import demo8_easymock_calculator.math.Division;

public class DivisionTest {
	
    @Test
    public void testCalculer() throws Exception {
        Division op = new Division();
        assertEquals(new Long(4), op.calculer(new Long(8),new Long(2)));
    }

    @Test
    public void testLireSymbole() throws Exception {
        Division op = new Division();
        assertEquals((Character)'/', op.lireSymbole());
    }
}
