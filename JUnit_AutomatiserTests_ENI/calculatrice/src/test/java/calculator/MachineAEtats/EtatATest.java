package calculator.MachineAEtats;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import calculator.MachineAEtats.EtatA;
import calculator.MachineAEtats.EtatAbstrait;
import calculator.math.Addition;

public class EtatATest {
    protected EtatAbstrait etat;

    @Before
    public void setUp() throws Exception {
        etat = new EtatA(new Long(0));    
        assertEquals("0", etat.lireAffichage());
     }

    @Test
    public void testAppuieChiffre() throws Exception {
        etat = etat.appuieChiffre(0);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("0", etat.lireAffichage());
        etat = etat.appuieChiffre(1);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("1", etat.lireAffichage());
        etat = etat.appuieChiffre(2);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("12", etat.lireAffichage());
        etat = etat.appuieChiffre(3);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("123", etat.lireAffichage());
        etat = etat.appuieChiffre(4);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("1234", etat.lireAffichage());
        etat = etat.appuieChiffre(5);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("12345", etat.lireAffichage());
        etat = etat.appuieChiffre(6);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("123456", etat.lireAffichage());
        etat = etat.appuieChiffre(7);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("1234567", etat.lireAffichage());
        etat = etat.appuieChiffre(8);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("12345678", etat.lireAffichage());
        etat = etat.appuieChiffre(9);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("123456789", etat.lireAffichage());
        etat = etat.appuieChiffre(0);
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        assertEquals("1234567890", etat.lireAffichage());
      }

    @Test
    public void testAppuieOperation() throws Exception {
        etat = etat.appuieOperation(new Addition());
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatOperation", etat.getClass().getName());
        assertEquals("+", etat.lireAffichage());
    }

    @Test
    public void testAppuieEgal() throws Exception {
        etat = etat.appuieEgal();
        assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatEgal", etat.getClass().getName());
        assertEquals("0", etat.lireAffichage());
    }
}
