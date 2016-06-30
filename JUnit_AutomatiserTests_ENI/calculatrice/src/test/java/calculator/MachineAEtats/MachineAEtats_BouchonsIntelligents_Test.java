package calculator.MachineAEtats;

import static org.junit.Assert.*;
import org.junit.Test;

import calculator.MachineAEtats.Etat;
import calculator.MachineAEtats.MachineAEtats;
import calculator.MachineAEtats.MachineAEtats_BouchonsActifs_Test.EtatBouchonActif;

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
	   	// Initialisation de la machine � �tats
		MachineAEtats mae = new MachineAEtats(bouchon);
	 
	    // V�rification de l'�tat initial
		assertEquals(null, bouchon.retourneDernierCaractere());	
		assertEquals("", mae.lireAffichage());	
		
		// Saisie de la premi�re touche
		mae.appuieTouche('1');
	
		// Le dernier caract�re saisie doit �tre celui transmis
		assertEquals(new Character('1'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le m�me
		assertEquals("1", mae.lireAffichage());	
		
		// Saisie de la seconde touche
		mae.appuieTouche('2');
	
		// Le dernier caract�re saisie doit �tre celui transmis
		assertEquals(new Character('2'),bouchon.retourneDernierCaractere());
		// L'affichage doit �voluer en fonction de la touche saisie
		assertEquals("12", mae.lireAffichage());	
	}
	
	@Test
	public void testAvecEtatBouchonIntelligentKO() {
		// Initialisation du bouchon
		EtatBouchonActif bouchon = new EtatBouchonIntelligent();
	   	// Initialisation de la machine � �tats
		MachineAEtats mae = new MachineAEtats(bouchon);
	 
	    // V�rification de l'�tat initial
		assertEquals(null, bouchon.retourneDernierCaractere());	
		assertEquals("", mae.lireAffichage());	
		
		// Saisie de la premi�re touche
		mae.appuieTouche('1');
	
		// Le dernier caract�re saisie doit �tre celui transmis
		assertEquals(new Character('1'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le m�me
		assertEquals("1", mae.lireAffichage());	
		
		// Saisie de la touche d'erreur
		mae.appuieTouche('E');
	
		// Validation du dernier caract�re transmis
		assertEquals(new Character('E'),bouchon.retourneDernierCaractere());
		// L'affichage doit passer en erreur
		assertEquals("ERREUR", mae.lireAffichage());	
	
		
		// Saisie d'une troisi�me touche afin de valider le comportement
		mae.appuieTouche('2');
	
		// V�rificaiton que la machine � �tats n'a pas transmis la touche
		assertEquals(new Character('E'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le m�me
		assertEquals("ERREUR", mae.lireAffichage());	
	}
	
}
