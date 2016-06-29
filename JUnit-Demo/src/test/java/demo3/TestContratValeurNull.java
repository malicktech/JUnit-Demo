package demo3;

import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;

public class TestContratValeurNull {

	/* 
	 *  Contrat "valeur null" : IsNull
	 *  
	 *  Le contrat vérifie que la référence passée en premier paramètre de l'assertion est null ou n'est pas null.
	 *  
	 * */
	
	@Test
    public void valeurNull1() {
        final String lTexte = null;
        Assert.assertThat(lTexte, IsNull.nullValue());
    }

    @Test
    public void valeurNull2() {
        final String lTexte = "texte";
        Assert.assertThat(lTexte, IsNull.nullValue());
    }

    @Test
    public void valeurPasNull1() {
        final String lTexte = null;
        Assert.assertThat(lTexte, IsNull.notNullValue());
    }

    @Test
    public void valeurPasNull2() {
        final String lTexte = "texte";
        Assert.assertThat(lTexte, IsNull.notNullValue());
    }
}
