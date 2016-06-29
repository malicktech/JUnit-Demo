package com.agilidee.livrejunit.servlet;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RequeteTest {
    protected Requete req;

    @Before
    public void setUp() {
        req = new Requete();    
    }

    @Test
    public void testgetsetID() {
        // Précise la condition initiale attendue
        assertTrue(req.getID().equals(-1));
        // Affecte le résultat voulu
        req.setID(1);
        // Permet de vérifier que l'affectation a bien fonctionnée               
        assertTrue(req.getID().equals(1));
    }

    @Test
    public void testadresseIp() {
        // Précise la condition initiale attendue
        assertTrue(req.getAdresseIp().equals(""));
        // Affecte le résultat voulu
        req.setAdresseIp("192.168.1.10");
        // Permet de vérifier que l'affectation a bien fonctionnée
        assertTrue(req.getAdresseIp().equals("192.168.1.10"));
    }

    @Test
    public void testgetsetDuree() {
        // Précise la condition initiale attendue
        assertTrue(req.getDuree().equals(0));
        // Affecte le résultat voulu
        req.setDuree(100);
        // Permet de vérifier que l'affectation a bien fonctionnée
        assertTrue(req.getDuree().equals(100));
    }

    @Test
    public void testgetsetParama() {
        // Précise la condition initiale attendue
        assertTrue(req.getParama().equals(new Long(0)));
        // Affecte le résultat voulu
        req.setParama(new Long(100));
        // Permet de vérifier que l'affectation a bien fonctionnée
        assertTrue(req.getParama().equals(new Long(100)));
    }

    @Test
    public void testgetsetParamb() {
        // Précise la condition initiale attendue
        assertTrue(req.getParamb().equals(new Long(0)));
        // Affecte le résultat voulu
        req.setParamb(new Long(100));
        // Permet de vérifier que l'affectation a bien fonctionnée
        assertTrue(req.getParamb().equals(new Long(100)));
    }

    @Test
    public void testgetsetResultat() {
        // Précise la condition initiale attendue
        assertTrue(req.getResultat().equals(new Long(0)));
        // Affecte le résultat voulu
        req.setResultat(new Long(100));
        // Permet de vérifier que l'affectation a bien fonctionnée
        assertTrue(req.getResultat().equals(new Long(100)));
    }
}
