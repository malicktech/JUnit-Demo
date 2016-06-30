package calculator.math;

import static org.junit.Assert.*;
import org.junit.Test;

import calculator.math.OperationReseau;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public abstract class OperationReseauTest {
    protected OperationReseau op;

    protected abstract OperationReseau fabriquerInstance();

    @Test
    public void testLireDonnees() throws Exception {
        op = fabriquerInstance();
        String s = "Ceci est la chaine d'origine.";
        InputStream is = new ByteArrayInputStream(s.getBytes());
        String resultat = op.lireDonnees(is);
        assertEquals("Resultat obetnu:" + resultat, resultat, s);
    }

    @Test
    public void testAnalyseResultat() throws Exception {
        op = fabriquerInstance();
        String resultat = "{\"resultat\":7896}";
        Long valeur = op.analyseResultat(resultat);
        assertEquals(new Long(7896), valeur);
    }
}
