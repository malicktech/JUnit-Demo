package demo8_easymock_calculator.MachineAEtats;

import demo8_easymock_calculator.math.*;

public abstract class EtatAbstrait implements Etat {
    
	protected Long nombreCourant;

	@Override
    public Etat appuieTouche(Character nomdetouche) throws Exception{
        switch (nomdetouche) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
                return appuieChiffre(Integer.parseInt(nomdetouche.toString()));
            case '+':
                return appuieOperation(new Addition());
            case '-':
                return appuieOperation(new Soustraction());
            case '*':
                return appuieOperation(new Multiplication());
            case '/':
                return appuieOperation(new Division());
            case 'G':
                return appuieOperation(new PGCD());
            case 'P':
                return appuieOperation(new PPCM());    
            case '=':
                return appuieEgal();
            default:
                throw new IllegalArgumentException();
        }
    }

	@Override
    public String lireAffichage() {
            return nombreCourant.toString();
    }

    public abstract EtatAbstrait appuieChiffre(Integer chiffre) throws Exception;
    public abstract EtatAbstrait appuieOperation(Operation op) throws Exception;
    public abstract EtatAbstrait appuieEgal() throws Exception ;

}
