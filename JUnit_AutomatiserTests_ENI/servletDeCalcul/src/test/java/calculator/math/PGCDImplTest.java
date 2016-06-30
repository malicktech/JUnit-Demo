package calculator.math;

import org.junit.Test;

import calculator.math.PGCDImpl;

import static org.junit.Assert.*;

public class PGCDImplTest {
    @Test
    public void testPGCD() {
        PGCDImpl op = new PGCDImpl();
        assertEquals(new Long(6), op.calculer(new Long(18),new Long(30)));
        assertEquals(new Long(6), op.calculer(new Long(30),new Long(18)));
        assertEquals(new Long(3), op.calculer(new Long(12),new Long(15)));
    }
}
