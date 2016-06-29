package com.agilidee.livrejunit.calculatrice.math;

import static org.junit.Assert.*;
import org.junit.Test;

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
