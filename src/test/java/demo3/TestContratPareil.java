package demo3;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.hamcrest.core.IsSame;
import org.junit.Assert;
import org.junit.Test;

public class TestContratPareil {

	/* Contrat "pareil" : IsSame */
	/*
	 * Le contrat vérifie que l'instance passée en premier paramètre de
	 * l'assertion et celle passée en paramètre du contrat sont les mêmes.
	 */

	@Test
	public void pareil() {
		// Remarque : c'est la même instance à cause du cache
		Assert.assertThat("texte", IsSame.sameInstance("texte"));
	}

	@Test
	public void pareil2() {
		// Remarque : c'est la même instance à cause du cache
		assertSame("should be same", "texte", "texte");
	}

	@Test
	public void pasPareil() {
		// Remarque : ce n'est pas la même instance parce que new String() force
		// une nouvelle instance.
		Assert.assertThat(new String("texte"), IsSame.sameInstance("texte"));
		assertNotSame("should not be same Object", new Object(), new Object());
	}

	@Test
	public void pasPareil2() {
		// Remarque : ce n'est pas la même instance parce que new String() force
		// une nouvelle instance.
		assertNotSame("should not be same Object", new String("texte"), "texte");
	}

}
