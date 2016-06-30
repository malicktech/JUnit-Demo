package calculator.math;

public class PGCD extends OperationReseau {
    public PGCD() {
       super(new InputStreamFactoryReseau());
    }

    public PGCD(IInputStreamFactory isf) {
        super(isf);
    }

    @Override
    public Character lireSymbole() {
        return 'G';
    }

    @Override
    public String getNomReseau() {
        return "pgcd";
    }
}
