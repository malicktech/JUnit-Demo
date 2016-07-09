package demo8_easymock_calculator.math;

import static org.junit.Assert.*;
import org.junit.Test;

import calculator.math.Multiplication;

public class MultiplicationTest {
     @Test
    public void testCalculer() throws Exception {
        Multiplication op = new Multiplication();
        assertEquals(new Long(16), op.calculer(new Long(8),new Long(2)));
    }

    @Test
    public void testLireSymbole() throws Exception {
        Multiplication op = new Multiplication();
        assertEquals((Character)'*', op.lireSymbole());
    }
}
