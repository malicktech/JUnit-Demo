package com.agilidee.livrejunit.calculatrice.MachineAEtats;

import com.agilidee.livrejunit.calculatrice.math.Operation;

public class EtatEgal extends EtatAbstrait {
    public EtatEgal(Long pNombre) {
         nombreCourant = pNombre;
    }

    @Override
    public EtatAbstrait appuieChiffre(Integer chiffre) {
        return new EtatA(new Long(chiffre));
    }

    @Override
    public EtatAbstrait appuieOperation(Operation op) {
        return new EtatOperation(nombreCourant, op);
    }

    @Override
    public EtatAbstrait appuieEgal() {
        return this;  
    }
}
