package demo3;

import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;

public class TestContratAllOf {

	/* contrat vérifie que tous les contrats passés en paramètre du contrat sont respectés. */
	
	@Test
    public void classeDeStringEtEgal() {
        Assert.assertThat("texte", AllOf.allOf(
                IsInstanceOf.instanceOf(String.class), IsEqual.equalTo("texte")
        ));
    }

    @Test
    public void classeDeIntegerEtEgal() {
        Assert.assertThat("texte", AllOf.allOf(
                IsInstanceOf.instanceOf(Integer.class), IsEqual.equalTo("texte")
        ));
    }

    @Test
    public void classeDeStringEtPasEgal() {
        Assert.assertThat("texte", AllOf.allOf(
                IsInstanceOf.instanceOf(String.class), IsEqual.equalTo("Texte")
        ));
    }

    @Test
    public void classeDeIntegerEtPasEgal() {
        Assert.assertThat("texte", AllOf.allOf(
                IsInstanceOf.instanceOf(Integer.class), IsEqual.equalTo("Texte")
        ));
    }

    @Test
    public void classeDePasIntegerEtEgal() {
        Assert.assertThat("texte", AllOf.allOf(
                IsNot.not(IsInstanceOf.instanceOf(Integer.class)), IsEqual.equalTo("texte")
        ));
    }

    @Test
    public void classeDeStringEtPasPasEgal() {
        Assert.assertThat("texte", AllOf.allOf(
                IsInstanceOf.instanceOf(String.class), IsNot.not(IsEqual.equalTo("Texte"))
        ));
    }
}
