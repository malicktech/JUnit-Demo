package com.agilidee.livrejunit.calculatrice.MachineAEtats;

import org.junit.Assert;
import org.junit.Test;

public class MachineAEtats_BouchonsActifs_Test {

	abstract static protected class EtatBouchonActif implements Etat {
		protected Character dernierCaratere = null;
		
		public Character retourneDernierCaractere() {
			return dernierCaratere;
		}
	
		@Override
		public final Etat appuieTouche(Character nomdetouche) throws Exception {
			dernierCaratere = nomdetouche;
			return appuieVraimentTouche(nomdetouche);
		}
	
		@Override
		public abstract String lireAffichage();

		public abstract Etat appuieVraimentTouche(Character nomdetouche) throws Exception;
	}

	
	class EtatBouchonActifOK extends EtatBouchonActif{
		@Override
		public Etat appuieVraimentTouche(Character nomdetouche) throws Exception {
			return this;
		}
	
		@Override
		public String lireAffichage() {
			return "EtatBouchonActifOK";
		}
	}
	
	class EtatBouchonActifKO extends EtatBouchonActif {
		@Override
		public Etat appuieVraimentTouche(Character nomdetouche) throws Exception {
			throw new Exception("EtatBouchonActifKO");
		}
	
		@Override
		public String lireAffichage() {
			return "EtatBouchonActifKO";
		}
	}
	
	@Test
	public void testAvecBouchonActifOK() {	
		// Initialisation du bouchon
		EtatBouchonActif bouchon = new EtatBouchonActifOK();
	   	// Initialisation de la machine à états
		MachineAEtats mae = new MachineAEtats(bouchon);
	 
	    // Vérification de l'état initial
		Assert.assertEquals(null, bouchon.retourneDernierCaractere());	
		Assert.assertEquals("EtatBouchonActifOK", mae.lireAffichage());	
		
		// Charge utile de code
		mae.appuieTouche('1');
	
		// Le dernier caractère saisie doit être celui transmis
		Assert.assertEquals(new Character('1'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le même
		Assert.assertEquals("EtatBouchonActifOK", mae.lireAffichage());	
	}
	
	@Test
	public void testAvecBouchonActifKO() {
		// Initialisation du bouchon
		EtatBouchonActif bouchon = new EtatBouchonActifKO();
	   	// Initialisation de la machine à états
		MachineAEtats mae = new MachineAEtats(bouchon);
	 
	    // Vérification de l'état initial
		Assert.assertEquals(null, bouchon.retourneDernierCaractere());	
		Assert.assertEquals("EtatBouchonActifKO", mae.lireAffichage());	
		
		// Charge utile de code
		mae.appuieTouche('1');
	
		// Le dernier caractère saisie doit être celui transmis
		Assert.assertEquals(new Character('1'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le même
		Assert.assertEquals("ERREUR", mae.lireAffichage());	
	}
}
