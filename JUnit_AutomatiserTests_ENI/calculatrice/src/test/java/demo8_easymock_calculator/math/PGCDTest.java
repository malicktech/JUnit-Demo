package demo8_easymock_calculator.math;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import calculator.math.OperationReseau;
import calculator.math.PGCD;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

public class PGCDTest extends OperationReseauTest {
    @Override
    protected  OperationReseau fabriquerInstance() {
        return new PGCD();
    }

    @Test
    public void testCalculer() throws Exception {
        PGCD op = new PGCD();
        Assert.assertEquals(new Long(6), op.calculer(new Long(18),new Long(30)));
        Assert.assertEquals(new Long(3), op.calculer(new Long(12),new Long(15)));
    }

    class InputStreamFactoryBouchon implements OperationReseau.IInputStreamFactory {
        public InputStream recupereIS(URL url) {
            String source;
            if (url.toString().contains("a=18"))
                source = "{\"resultat\":6}";
            else
                source = "{\"resultat\":3}";
            return new ByteArrayInputStream(source.getBytes());
        }
    }
    
    @Test
    public void testCalculer_AvecBouchon() throws Exception {
        PGCD op = new PGCD(new InputStreamFactoryBouchon());
        
        Assert.assertEquals(new Long(6), op.calculer(new Long(18),new Long(30)));
        Assert.assertEquals(new Long(3), op.calculer(new Long(12),new Long(15)));
    }
    
    @Test
    public void testLireSymbole() throws Exception {
        PGCD op = new PGCD();
        Assert.assertEquals((Character)'G', op.lireSymbole());
    }

    @Test
    public void testConstruireURL() throws Exception {
        PGCD op = new PGCD();
        URL validation = new URL(op.baseurl + "?operation=pgcd&a=18&b=30");
        Assert.assertEquals(validation, op.construireURL(new Long(18),new Long(30)));
    }
}
