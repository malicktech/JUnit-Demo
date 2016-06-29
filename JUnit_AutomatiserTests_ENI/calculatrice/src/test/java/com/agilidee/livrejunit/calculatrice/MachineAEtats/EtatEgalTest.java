package com.agilidee.livrejunit.calculatrice.MachineAEtats;

import com.agilidee.livrejunit.calculatrice.math.Addition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EtatEgalTest {
    protected EtatAbstrait etat;

     @Before
     public void setUp() throws Exception {
         // Le test démarre toujours avec un EtatEgal initialisé
    	 etat = new EtatEgal(new Long(0));
    	 // Validation de l'état initial
         Assert.assertEquals("0", etat.lireAffichage());
      }

    @Test
    public void testAppuieChiffre() throws Exception {
        // Envoi du signal
    	etat = etat.appuieChiffre(1);
        // Validation de la transition
    	Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatA", etat.getClass().getName());
        // Validation de l'affichage
    	Assert.assertEquals("1", etat.lireAffichage());
    }

    @Test
    public void testAppuieOperation() throws Exception {
        // Envoi du signal
        etat = etat.appuieOperation(new Addition());
	    // Validation de la transition
        Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatOperation", etat.getClass().getName());
        // Validation de l'affichage
        Assert.assertEquals("+", etat.lireAffichage());
     }

    @Test
    public void testAppuieEgal() throws Exception {
        // Envoi du signal
		etat = etat.appuieEgal();
	    // Validation de la transition
		Assert.assertEquals("com.agilidee.livrejunit.calculatrice.MachineAEtats.EtatEgal", etat.getClass().getName());
        // Validation de l'affichage
		Assert.assertEquals("0", etat.lireAffichage());
     }
}
