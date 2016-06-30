package calculator.MachineAEtats;

import calculator.math.Operation;

public class EtatOperation extends EtatAbstrait{

    protected Operation operationCourante;

   public EtatOperation(Long pNombre,  Operation pOp) {
       nombreCourant = pNombre;
       operationCourante = pOp;
   }


    @Override
    public EtatAbstrait appuieChiffre(Integer chiffre) {
        return new EtatB(new Long(chiffre), nombreCourant, operationCourante);
    }

    @Override
    public EtatAbstrait appuieOperation(Operation op) {
        operationCourante = op;
        return this;
    }

    @Override
    public EtatAbstrait appuieEgal() {
        return new EtatEgal(nombreCourant);
    }
   @Override
    public String lireAffichage() {
        return operationCourante.lireSymbole().toString();
    }
}
