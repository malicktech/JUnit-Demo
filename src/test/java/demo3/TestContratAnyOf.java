package demo3;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

public class TestContratAnyOf {

	/* 
	 * Contrat "au moins un" : AnyOf
	 * 
	 * Le contrat vérifie qu'au moins un des contrats passés en paramètre du contrat est respecté.
	 * les assertions où au moins un sous-contrat est respecté réussissent
	 */
	
	@Test
    public void classeDeStringEtEgal() {
        Assert.assertThat("texte", AnyOf.anyOf(
                IsInstanceOf.instanceOf(String.class), IsEqual.equalTo("texte")
        ));
    }

    @Test
    public void classeDeIntegerEtEgal() {
        Assert.assertThat("texte", AnyOf.anyOf(
                IsInstanceOf.instanceOf(Integer.class), IsEqual.equalTo("texte")
        ));
    }

    @Test
    public void classeDeStringEtPasEgal() {
        Assert.assertThat("texte", AnyOf.anyOf(
                IsInstanceOf.instanceOf(String.class), IsEqual.equalTo("Texte")
        ));
    }

    @Test
    public void classeDeIntegerEtPasEgal() {
        Assert.assertThat("texte", AnyOf.anyOf(
                IsInstanceOf.instanceOf(Integer.class), IsEqual.equalTo("Texte")
        ));
    }
}
