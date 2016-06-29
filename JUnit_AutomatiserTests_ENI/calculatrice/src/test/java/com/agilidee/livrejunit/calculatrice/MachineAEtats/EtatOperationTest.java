package com.agilidee.livrejunit.calculatrice.MachineAEtats;

import com.agilidee.livrejunit.calculatrice.math.Addition;
import com.agilidee.livrejunit.calculatrice.math.Soustraction;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class EtatOperationTest {
    protected EtatAbstrait etat;

    @Before
    public void setUp() throws Exception {
        etat = new EtatOperation(new Long(0), new Addition());
        assertEquals("+", etat.lireAffichage());
    }

    @Test
    public void testAppuieChiffre() throws Exception {
        etat = etat.appuieChiffre(1);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        assertEquals("1", etat.lireAffichage());
    }

    @Test
    public void testAppuieOperation() throws Exception {
        etat = etat.appuieOperation(new Soustraction());
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatOperation", etat.getClass().getName());
        assertEquals("-", etat.lireAffichage());
    }
    
    @Test
    public void testAppuieEgal() throws Exception {
        etat = etat.appuieEgal();
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatEgal", etat.getClass().getName());
        assertEquals("0", etat.lireAffichage());
    }
}
