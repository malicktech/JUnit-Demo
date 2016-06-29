package com.agilidee.livrejunit.calculatrice.MachineAEtats;

public interface Etat {
	   public Etat appuieTouche(Character nomdetouche) throws Exception;
	   public String lireAffichage();
}
