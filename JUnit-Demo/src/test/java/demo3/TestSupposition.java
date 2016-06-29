package demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class TestSupposition {

	/*
	 * Les suppositions sont présentes dans JUnit depuis la version 4.4.
	 * 
	 * Une supposition vérifie une condition. Si la condition n'est pas
	 * vérifiée, le test s'arrête mais ne passe pas en erreur ou en échec.
	 * 
	 * Les différentes suppositions sont :
	 * 
	 * assumeNoException(java.lang.Throwable) : vérifie qu'une opération s'est
	 * déroulée sans lever de Throwable
	 * 
	 * assumeNotNull(java.lang.Object...) : vérifie qu'aucun des paramètres
	 * n'est à null.
	 * 
	 * assumeThat(T, org.hamcrest.Matcher) : vérifie qu'une condition définie
	 * par contrat est respectée (voir
	 * "Assertion sur une condition définie par contrat").
	 * 
	 * assumeTrue(boolean) : vérifie que le paramètre est vrai.
	 */
	@Test
	public void verifierExistenceFichier() {
		final File lFile = new File("fichier.txt");
		Assert.assertTrue("Le fichier doit exister", lFile.exists());
	}

	@Test
    public void lireFichier() throws IOException {
        final File lFile = new File("fichier.txt");
        Assume.assumeTrue(lFile.exists());
        
        final FileInputStream lFileInputStream = new FileInputStream(lFile);
        final byte[] lBytes = new byte[16];
        lFileInputStream.read(lBytes);
        Assert.assertArrayEquals("Bonjour le monde".getBytes(), lBytes);
    }

	/*
	 * si le fichier n'existe pas, seul le test vérifiant la présence du fichier
	 * passe en échec.
	 */
	
}