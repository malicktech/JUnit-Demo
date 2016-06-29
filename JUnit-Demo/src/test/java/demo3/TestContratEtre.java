package demo3;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsSame;
import org.junit.Assert;
import org.junit.Test;

public class TestContratEtre {

	/*
	 * Contrat "être" : Is
	 * 
	 * Le contrat vérifie que l'instance passée en premier paramètre correspond
	 * à ce qui est passé (classe, valeur, autre contrat) en paramètre du
	 * contrat. Ce contrat n'apporte pas de nouveau type de contrat :
	 * 
	 * si on passe une classe, cela correspond à un contrat
	 * "classe de l'instance"
	 * 
	 * si on passe une valeur, cela correspond à un contrat "égalité"
	 * 
	 * si on passe un autre contrat, cela correspond à cet autre contrat
	 */


    @Test
    public void egal() {
        Assert.assertThat("texte", Is.is("texte"));
    }

    @Test
    public void pasEgal() {
        Assert.assertThat("Texte", Is.is("texte"));
    }

    @Test
    public void pareil() {
        Assert.assertThat("texte", Is.is(IsSame.sameInstance("texte")));
    }

    @Test
    public void pasPareil() {
        Assert.assertThat(new String("texte"), Is.is(IsSame.sameInstance("texte")));
    }
}
