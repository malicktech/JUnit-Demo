package calculator.MachineAEtats;

public interface Etat {
	   public Etat appuieTouche(Character nomdetouche) throws Exception;
	   public String lireAffichage();
}
