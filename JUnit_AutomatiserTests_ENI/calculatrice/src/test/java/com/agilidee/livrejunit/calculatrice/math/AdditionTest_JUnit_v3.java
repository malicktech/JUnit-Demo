package com.agilidee.livrejunit.calculatrice.math;

import junit.framework.TestCase;

public class AdditionTest_JUnit_v3 extends TestCase {
    protected Addition op;

    public void setUp() throws Exception {
        super.setUp();
        op = new Addition();
    }

    public void tearDown() throws Exception {
        super.tearDown();       
    }

    public void testCalculer() throws Exception {
        assertEquals(new Long(4), op.calculer(new Long(1),new Long(3)));
    }

    public void testLireSymbole() throws Exception {
        assertEquals((Character)'+', op.lireSymbole());
    }
}
