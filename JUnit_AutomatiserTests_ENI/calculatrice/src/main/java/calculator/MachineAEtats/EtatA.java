package calculator.MachineAEtats;

import calculator.math.Operation;

public class EtatA extends EtatAbstrait {

     public EtatA(Long pNombre) {
        nombreCourant = pNombre;
    }

    @Override
    public EtatAbstrait appuieChiffre(Integer chiffre) {
        nombreCourant = nombreCourant * 10 + chiffre;
        return this;
    }

    @Override
    public EtatAbstrait appuieOperation(Operation op) {
        return new EtatOperation(nombreCourant, op);
    }

    @Override
    public EtatAbstrait appuieEgal() {
        return new EtatEgal(nombreCourant);
    }
}
