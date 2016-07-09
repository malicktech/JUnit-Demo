package demo8_easymock_calculator.MachineAEtats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import calculator.math.Addition;
import calculator.math.Soustraction;
import demo8_easymock_calculator.MachineAEtats.EtatAbstrait;
import demo8_easymock_calculator.MachineAEtats.EtatB;

public class EtatBTest {
    protected EtatAbstrait etat;

    @Before
    public void setUp() throws Exception {
        etat = new EtatB(new Long(0), new Long(10), new Addition());
        Assert.assertEquals("0", etat.lireAffichage());
     }

    @Test
    public void testAppuieChiffre() throws Exception {
       etat = etat.appuieChiffre(0);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("0", etat.lireAffichage());
        etat = etat.appuieChiffre(1);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("1", etat.lireAffichage());
        etat = etat.appuieChiffre(2);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("12", etat.lireAffichage());
        etat = etat.appuieChiffre(3);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("123", etat.lireAffichage());
        etat = etat.appuieChiffre(4);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("1234", etat.lireAffichage());
        etat = etat.appuieChiffre(5);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("12345", etat.lireAffichage());
        etat = etat.appuieChiffre(6);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("123456", etat.lireAffichage());
        etat = etat.appuieChiffre(7);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("1234567", etat.lireAffichage());
        etat = etat.appuieChiffre(8);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("12345678", etat.lireAffichage());
        etat = etat.appuieChiffre(9);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("123456789", etat.lireAffichage());
        etat = etat.appuieChiffre(0);
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatB", etat.getClass().getName());
        Assert.assertEquals("1234567890", etat.lireAffichage());
      }

    @Test
    public void testAppuieOperation() throws Exception {
        etat = etat.appuieOperation(new Soustraction());
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatOperation", etat.getClass().getName());
        Assert.assertEquals("-", etat.lireAffichage());
    }

    @Test
    public void testAppuieEgal() throws Exception {
        etat = etat.appuieEgal();
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatEgal", etat.getClass().getName());
        Assert.assertEquals("10", etat.lireAffichage());
    }
}
