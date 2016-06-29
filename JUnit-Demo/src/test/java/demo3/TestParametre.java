package demo3;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestParametre {

	/*
	 * Les tests paramétrés permettent d'exécuter plusieurs fois un cas de tests avec des valeurs différentes.
	 */
	
    @Parameters
    public static List<Object[]> getParametres() {
        return Arrays.asList(new Object[][] {
                { 10L, 0L, new long[] { 10L, 0L } },
                { 30L, 300L, new long[] { 10L, 20L } },
                { 7936L, 1125899906842624L, new long[] { 256L, 512L, 1024L, 2048L, 4096L } }, 
        });
    }

    private long resultatAddition;
    private long resultatMultiplication;
    private long[] nombres;

    public TestParametre(long pResultatAddition, long pResultatMultiplication, long[] pNombres) {
        resultatAddition = pResultatAddition;
        resultatMultiplication = pResultatMultiplication;
        nombres = pNombres;
    }

    @Test
    public void addition() {
        System.out.println("addition :      - attendu : " + resultatAddition + 
                         "\n                - nombres : " + Arrays.toString(nombres));
        final long lAddition = Operations.additionner(nombres);
        Assert.assertEquals(resultatAddition, lAddition);
    }

    @Test
    public void mutiplication() {
        System.out.println("mutiplication : - attendu : " + resultatMultiplication + 
                         "\n                - nombres : " + Arrays.toString(nombres));
        final long lMultiplication = Operations.multiplier(nombres);
        Assert.assertEquals(resultatMultiplication, lMultiplication);
    }
}