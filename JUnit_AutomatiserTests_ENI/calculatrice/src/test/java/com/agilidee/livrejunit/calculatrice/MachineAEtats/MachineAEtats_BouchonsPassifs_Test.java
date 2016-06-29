package com.agilidee.livrejunit.calculatrice.MachineAEtats;

import org.junit.Assert;
import org.junit.Test;

public class MachineAEtats_BouchonsPassifs_Test {
	
	class EtatBouchonPassifOK implements Etat {
		@Override
		public Etat appuieTouche(Character nomdetouche) throws Exception {
			return this;
		}

		@Override
		public String lireAffichage() {
			return "EtatBouchonPassifOK";
		}
	}
	
	class EtatBouchonPassifKO implements Etat {
		@Override
		public Etat appuieTouche(Character nomdetouche) throws Exception {
			throw new Exception("EtatBouchonPassifKO");
		}

		@Override
		public String lireAffichage() {
			return "EtatBouchonPassifKO";
		}
	}
	
    @Test
	public void testAvecBouchonPassifOK() {
      	//Initialisation du bouchon
		Etat bouchon = new EtatBouchonPassifOK();
    	// Initialisation de la machine à états
		MachineAEtats mae = new MachineAEtats(bouchon);
    	
		// Vérification du message avant l'appuie d'une touche
		Assert.assertEquals("EtatBouchonPassifOK", mae.lireAffichage());
   	
		// Charge utile de code
		mae.appuieTouche('1');
    		
		// L'affichage doit rester le même
		Assert.assertEquals("EtatBouchonPassifOK", mae.lireAffichage());
    }
	    
	@Test
	public void testAvecBouchonPassifKO() {
       	//Initialisation du bouchon
		Etat bouchon = new EtatBouchonPassifKO();
    	// Initialisation de la machine à états
		MachineAEtats mae = new MachineAEtats(bouchon);
    	
		// Vérification du message avant la mise en erreur
		Assert.assertEquals("EtatBouchonPassifKO", mae.lireAffichage());
    	
    	// Charge utile de code
		mae.appuieTouche('1');
    		
		// L'affichage doit indiquer 'ERREUR'
		Assert.assertEquals("ERREUR", mae.lireAffichage());
	}
}
