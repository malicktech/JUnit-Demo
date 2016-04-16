package demo3;

import org.junit.Assert;
import org.junit.Test;

public class TestDoubleAvecDelta {

	/*
	 * Cette assertion est présente dans JUnit depuis la version 4.4.
	 * L'assertion d'égalité pour les doubles sans delta est passé en déprécié à
	 * partir de la version 4.5 de JUnit le paramètre delta permet de considérer
	 * que l'assertion est juste même s'il y a une différence entre les valeurs,
	 * tant que cette différence est inférieure au delta.
	 */

	@Test
	public void valeursExactementEgales() {
		final double lResultat = Operations.soustraire(5, 2.5);
		Assert.assertEquals(2.5, lResultat, 0);
	}

	@Test
	public void valeursAvecUneLegereDifference() {
		final double lResultat = Operations.soustraire(71.19, 98);
		Assert.assertEquals(-26.81, lResultat, 0.005);
	}

	@Test
	public void valeursAvecUneDifferenceTropImportante() {
		final double lResultat = Operations.soustraire(71.19, 98);
		Assert.assertEquals(-26.81, lResultat, 0);
	}
}
