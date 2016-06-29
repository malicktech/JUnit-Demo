package demo3;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestIndisponibilite {

	/* permet de pas passer un test */

	@Test
	public void nonIgnore1() {

	}

	@Test
	public void nonIgnore2() {
		Assert.fail("Echec");
	}

	@Ignore
	@Test
	public void ignore() {
		Assert.fail("Echec ignoré");
	}
}
