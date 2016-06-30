package calculator.IHM;

import static org.junit.Assert.*;
import org.junit.Test;

import calculator.IHM.Modele;

public class ModeleTest {
    @Test
    public void testModele_4Operations() {
        Modele controleur = new Modele();
        assertEquals("0", controleur.lireAffichage());

        controleur.appuieTouche('1');
        assertEquals("1", controleur.lireAffichage());
        controleur.appuieTouche('2');
        assertEquals("12", controleur.lireAffichage());

        controleur.appuieTouche('+');
        assertEquals("+", controleur.lireAffichage());

        controleur.appuieTouche('3');
        assertEquals("3", controleur.lireAffichage());
        controleur.appuieTouche('4');
        assertEquals("34", controleur.lireAffichage());

        controleur.appuieTouche('=');
        assertEquals("46", controleur.lireAffichage());

        controleur.appuieTouche('-');
        assertEquals("-", controleur.lireAffichage());

        controleur.appuieTouche('7');
        assertEquals("7", controleur.lireAffichage());

        controleur.appuieTouche('=');
        assertEquals("39", controleur.lireAffichage());

        controleur.appuieTouche('+');
        assertEquals("+", controleur.lireAffichage());

        controleur.appuieTouche('1');
        assertEquals("1", controleur.lireAffichage());

        controleur.appuieTouche('/');
        assertEquals("/", controleur.lireAffichage());

        controleur.appuieTouche('8');
        assertEquals("8", controleur.lireAffichage());

        controleur.appuieTouche('=');
        assertEquals("5", controleur.lireAffichage());

        controleur.appuieTouche('*');
        assertEquals("*", controleur.lireAffichage());

        controleur.appuieTouche('9');
        assertEquals("9", controleur.lireAffichage());

        controleur.appuieTouche('=');
        assertEquals("45", controleur.lireAffichage());

        controleur.appuieTouche('1');
        assertEquals("1", controleur.lireAffichage());

        controleur.appuieTouche('P');
        assertEquals("P", controleur.lireAffichage());

        controleur.appuieTouche('1');
        assertEquals("1", controleur.lireAffichage());

        controleur.appuieTouche('G');
        assertEquals("G", controleur.lireAffichage());

        controleur.appuieTouche('1');
        assertEquals("1", controleur.lireAffichage());
      }
}
