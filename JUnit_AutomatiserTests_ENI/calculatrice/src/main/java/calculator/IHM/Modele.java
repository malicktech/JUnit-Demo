package calculator.IHM;

import calculator.MachineAEtats.MachineAEtats;

public class Modele {
     protected MachineAEtats mae = new MachineAEtats();

    public void appuieTouche(char nomdetouche) {
        mae.appuieTouche(nomdetouche);
    }

    public String lireAffichage() {
        return mae.lireAffichage();
    }
}
