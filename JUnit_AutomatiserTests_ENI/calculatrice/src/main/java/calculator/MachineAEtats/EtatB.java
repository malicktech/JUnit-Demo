package calculator.MachineAEtats;

import calculator.math.Operation;

public class EtatB extends EtatAbstrait{

    protected Long nombreMemorise;
    protected Operation operationCourante;

    public EtatB(Long pNc, Long pNm,  Operation pOp) {
        nombreCourant = pNc;
        nombreMemorise = pNm;
        operationCourante = pOp;
    }

    @Override
    public EtatAbstrait appuieChiffre(Integer chiffre) {
        nombreCourant = nombreCourant * 10 + chiffre;
        return this;
     }

    @Override
    public EtatAbstrait appuieOperation(Operation op) throws Exception{
        return new EtatOperation(operationCourante.calculer(nombreMemorise, nombreCourant), op);
     }

    @Override
    public EtatAbstrait appuieEgal() throws Exception{
        return new EtatEgal(operationCourante.calculer(nombreMemorise, nombreCourant));
    }
}
