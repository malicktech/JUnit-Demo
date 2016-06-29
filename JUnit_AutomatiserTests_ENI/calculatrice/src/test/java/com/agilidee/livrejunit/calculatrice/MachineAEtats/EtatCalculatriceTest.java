package com.agilidee.livrejunit.calculatrice.MachineAEtats;

import com.agilidee.livrejunit.calculatrice.math.Operation;
import static org.junit.Assert.*;
import org.junit.Test;

public class EtatCalculatriceTest {
    protected class MockEtatCalculatrice extends EtatAbstrait{
        protected String display;
        @Override
        public EtatAbstrait appuieChiffre(Integer chiffre) {
            display = chiffre.toString();
            return this;
        }

        @Override
        public EtatAbstrait appuieOperation(Operation op) {
            display = op.lireSymbole().toString();
            return this;
        }

        @Override
        public EtatAbstrait appuieEgal() {
            display = "=";
            return this;
        }

        @Override
        public String lireAffichage() {
            return display;
        }
    }
    
    @Test(expected= IllegalArgumentException.class)
    public void testAppuieToucheInconnue() throws Exception {
        MockEtatCalculatrice mock = new MockEtatCalculatrice();
        mock.appuieTouche('X');                
    }
    
    @Test
     public void testAppuieTouche() throws Exception {
        MockEtatCalculatrice mock = new MockEtatCalculatrice();
        mock.appuieTouche('0');
        assertEquals("0", mock.lireAffichage());
        mock.appuieTouche('1');
        assertEquals("1", mock.lireAffichage());
        mock.appuieTouche('2');
        assertEquals("2", mock.lireAffichage());
        mock.appuieTouche('3');
        assertEquals("3", mock.lireAffichage());
        mock.appuieTouche('4');
        assertEquals("4", mock.lireAffichage());
        mock.appuieTouche('5');
        assertEquals("5", mock.lireAffichage());
        mock.appuieTouche('6');
        assertEquals("6", mock.lireAffichage());
        mock.appuieTouche('7');
        assertEquals("7", mock.lireAffichage());
        mock.appuieTouche('8');
        assertEquals("8", mock.lireAffichage());
        mock.appuieTouche('9');
        assertEquals("9", mock.lireAffichage());
        mock.appuieTouche('+');
        assertEquals("+", mock.lireAffichage());
        mock.appuieTouche('-');
        assertEquals("-", mock.lireAffichage());
        mock.appuieTouche('/');
        assertEquals("/", mock.lireAffichage());
        mock.appuieTouche('*');
        assertEquals("*", mock.lireAffichage());
        mock.appuieTouche('=');
        assertEquals("=", mock.lireAffichage());
    }
}
