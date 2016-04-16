package demo3;

import org.junit.Test;

public class TestDureeLimitee {

	/* Test d'une durée limitée */
	/*
	 * permet de vérifier qu'un test ne dépasse pas une durée. Au delà de cette
	 * durée, le test passe en erreur. La durée en millisecondes est passée en
	 * paramètre à l'annotation.
	 */

	@Test(timeout = 1000)
	public void dureeRespectee() {

	}

	@Test(timeout = 1000)
	public void dureeNonRespectee() throws InterruptedException {
		Thread.sleep(10000);
	}
}
