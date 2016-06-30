package calculator.servlet;

import org.junit.Before;
import org.junit.Test;

import calculator.servlet.Requete;

import static org.junit.Assert.*;

public class RequeteTest {
    protected Requete req;

    @Before
    public void setUp() {
        req = new Requete();    
    }

    @Test
    public void testgetsetID() {
        // Pr�cise la condition initiale attendue
        assertTrue(req.getID().equals(-1));
        // Affecte le r�sultat voulu
        req.setID(1);
        // Permet de v�rifier que l'affectation a bien fonctionn�e               
        assertTrue(req.getID().equals(1));
    }

    @Test
    public void testadresseIp() {
        // Pr�cise la condition initiale attendue
        assertTrue(req.getAdresseIp().equals(""));
        // Affecte le r�sultat voulu
        req.setAdresseIp("192.168.1.10");
        // Permet de v�rifier que l'affectation a bien fonctionn�e
        assertTrue(req.getAdresseIp().equals("192.168.1.10"));
    }

    @Test
    public void testgetsetDuree() {
        // Pr�cise la condition initiale attendue
        assertTrue(req.getDuree().equals(0));
        // Affecte le r�sultat voulu
        req.setDuree(100);
        // Permet de v�rifier que l'affectation a bien fonctionn�e
        assertTrue(req.getDuree().equals(100));
    }

    @Test
    public void testgetsetParama() {
        // Pr�cise la condition initiale attendue
        assertTrue(req.getParama().equals(new Long(0)));
        // Affecte le r�sultat voulu
        req.setParama(new Long(100));
        // Permet de v�rifier que l'affectation a bien fonctionn�e
        assertTrue(req.getParama().equals(new Long(100)));
    }

    @Test
    public void testgetsetParamb() {
        // Pr�cise la condition initiale attendue
        assertTrue(req.getParamb().equals(new Long(0)));
        // Affecte le r�sultat voulu
        req.setParamb(new Long(100));
        // Permet de v�rifier que l'affectation a bien fonctionn�e
        assertTrue(req.getParamb().equals(new Long(100)));
    }

    @Test
    public void testgetsetResultat() {
        // Pr�cise la condition initiale attendue
        assertTrue(req.getResultat().equals(new Long(0)));
        // Affecte le r�sultat voulu
        req.setResultat(new Long(100));
        // Permet de v�rifier que l'affectation a bien fonctionn�e
        assertTrue(req.getResultat().equals(new Long(100)));
    }
}
