package com.agilidee.livrejunit.calculatrice.math;

import static org.junit.Assert.*;
import org.junit.Test;

public class PPCMTest extends OperationReseauTest{
    @Override
    protected  OperationReseau fabriquerInstance() {
        return new PPCM();
    }
    
    @Test
    public void testCalculer() throws Exception {
        PPCM op = new PPCM();
        assertEquals(new Long(30), op.calculer(new Long(15),new Long(10)));
        assertEquals(new Long(120), op.calculer(new Long(24),new Long(30)));
    }

    @Test
    public void testLireSymbole() throws Exception {
        PPCM op = new PPCM();
        assertEquals((Character)'P', op.lireSymbole());
    }
}
