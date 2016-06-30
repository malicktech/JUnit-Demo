package calculator.MachineAEtats;

import org.junit.Assert;
import org.junit.Test;

import calculator.MachineAEtats.Etat;
import calculator.MachineAEtats.MachineAEtats;

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
	   	// Initialisation de la machine ˆ Žtats
		MachineAEtats mae = new MachineAEtats(bouchon);
	 
	    // VŽrification de l'Žtat initial
		Assert.assertEquals(null, bouchon.retourneDernierCaractere());	
		Assert.assertEquals("EtatBouchonActifOK", mae.lireAffichage());	
		
		// Charge utile de code
		mae.appuieTouche('1');
	
		// Le dernier caract�re saisie doit �tre celui transmis
		Assert.assertEquals(new Character('1'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le m�me
		Assert.assertEquals("EtatBouchonActifOK", mae.lireAffichage());	
	}
	
	@Test
	public void testAvecBouchonActifKO() {
		// Initialisation du bouchon
		EtatBouchonActif bouchon = new EtatBouchonActifKO();
	   	// Initialisation de la machine ˆ Žtats
		MachineAEtats mae = new MachineAEtats(bouchon);
	 
	    // VŽrification de l'Žtat initial
		Assert.assertEquals(null, bouchon.retourneDernierCaractere());	
		Assert.assertEquals("EtatBouchonActifKO", mae.lireAffichage());	
		
		// Charge utile de code
		mae.appuieTouche('1');
	
		// Le dernier caract�re saisie doit �tre celui transmis
		Assert.assertEquals(new Character('1'),bouchon.retourneDernierCaractere());
		// L'affichage doit rester le m�me
		Assert.assertEquals("ERREUR", mae.lireAffichage());	
	}
}
