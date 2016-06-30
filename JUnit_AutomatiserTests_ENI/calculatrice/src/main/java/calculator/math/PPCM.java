package calculator.math;

public class PPCM extends OperationReseau {
    public PPCM() {
       super(new InputStreamFactoryReseau());
    }

   @Override
    public Character lireSymbole() {
        return 'P';
    }

    @Override
    public String getNomReseau() {
        return "ppcm";
    }
}
