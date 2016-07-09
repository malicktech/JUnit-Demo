package demo8_easymock_calculator.MachineAEtats;

public class MachineAEtats {
	
    private Etat etat = new EtatEgal(new Long(0));
    private Boolean drapeauDErreur = false;
     
    public MachineAEtats() {
    }

    public MachineAEtats(Etat etatInitial) {
    	etat = etatInitial;
    }

    public void appuieTouche(char nomdetouche) {
	    try {
	 		if (!drapeauDErreur)
	 			etat = etat.appuieTouche(nomdetouche);
	    } catch (Exception e) {
	    	drapeauDErreur = true;
	    }
	}
    
    public String lireAffichage() {
        if (!drapeauDErreur)
        	return etat.lireAffichage();
        else
        	return "ERREUR";
    }
}

