package demo8_easymock_calculator.MachineAEtats;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import demo8_easymock_calculator.math.Addition;
import demo8_easymock_calculator.math.Soustraction;
import demo8_easymock_calculator.MachineAEtats.EtatAbstrait;
import demo8_easymock_calculator.MachineAEtats.EtatOperation;


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
