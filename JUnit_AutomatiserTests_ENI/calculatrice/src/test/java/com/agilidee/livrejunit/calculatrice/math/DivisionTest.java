package com.agilidee.livrejunit.calculatrice.math;

import static org.junit.Assert.*;
import org.junit.Test;

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
