package com.agilidee.livrejunit.calculatrice.MachineAEtats;

import static org.junit.Assert.*;
import org.junit.Test;

import com.agilidee.livrejunit.calculatrice.MachineAEtats.MachineAEtats_BouchonsActifs_Test.EtatBouchonActif;

public class MachineAEtats_BouchonsIntelligents_Test {

class EtatBouchonIntelligent extends EtatBouchonActif {
	protected String display = "";
	
	@Override
	public Etat appuieVraimentTouche(Character nomdetouche) throws Exception {
		if (nomdetouche.equals('E')) {
			throw new Exception("EtatBouchonIntelligent");
		} else {
			display += nomdetouche;
			return this;
		}
	}

	@Override
	public String lireAffichage() {
		return display;
	}
}

	
	@Test
	public void testAvecEtatBouchonIntelligentOK() {	
		// Initialisation du bouchon
		EtatBouchonActif bouchon = new EtatBouchonIntelligent();
	   	// Initialisation de la machine à états
		MachineAEtats mae = new MachineAEtats(bouchon);
	 
	    // Vérification de l'état initial
		assertEquals(null, bouchon.retourneDernierCaractere());	
		assertEquals("", mae.lireAffichage());	
		
		// Saisie de la première touche
		mae.appuieTouche('1');
	
		// Le dernier caractère saisie doit être celui transmis
		assertEquals(new Character('1'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le même
		assertEquals("1", mae.lireAffichage());	
		
		// Saisie de la seconde touche
		mae.appuieTouche('2');
	
		// Le dernier caractère saisie doit être celui transmis
		assertEquals(new Character('2'),bouchon.retourneDernierCaractere());
		// L'affichage doit évoluer en fonction de la touche saisie
		assertEquals("12", mae.lireAffichage());	
	}
	
	@Test
	public void testAvecEtatBouchonIntelligentKO() {
		// Initialisation du bouchon
		EtatBouchonActif bouchon = new EtatBouchonIntelligent();
	   	// Initialisation de la machine à états
		MachineAEtats mae = new MachineAEtats(bouchon);
	 
	    // Vérification de l'état initial
		assertEquals(null, bouchon.retourneDernierCaractere());	
		assertEquals("", mae.lireAffichage());	
		
		// Saisie de la première touche
		mae.appuieTouche('1');
	
		// Le dernier caractère saisie doit être celui transmis
		assertEquals(new Character('1'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le même
		assertEquals("1", mae.lireAffichage());	
		
		// Saisie de la touche d'erreur
		mae.appuieTouche('E');
	
		// Validation du dernier caractère transmis
		assertEquals(new Character('E'),bouchon.retourneDernierCaractere());
		// L'affichage doit passer en erreur
		assertEquals("ERREUR", mae.lireAffichage());	
	
		
		// Saisie d'une troisième touche afin de valider le comportement
		mae.appuieTouche('2');
	
		// Vérificaiton que la machine à états n'a pas transmis la touche
		assertEquals(new Character('E'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le même
		assertEquals("ERREUR", mae.lireAffichage());	
	}
	
}
