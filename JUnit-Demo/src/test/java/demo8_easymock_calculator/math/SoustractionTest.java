package demo8_easymock_calculator.math;

import org.junit.Assert;
import org.junit.Test;

import demo8_easymock_calculator.math.Soustraction;

public class SoustractionTest {
    @Test
    public void testCalculer() throws Exception {
        Soustraction op = new Soustraction();
        Assert.assertEquals(new Long(4), op.calculer(new Long(7),new Long(3)));
    }
    @Test
    public void testLireSymbole() throws Exception {
        Soustraction op = new Soustraction();
        Assert.assertEquals((Character)'-', op.lireSymbole());
    }
}
