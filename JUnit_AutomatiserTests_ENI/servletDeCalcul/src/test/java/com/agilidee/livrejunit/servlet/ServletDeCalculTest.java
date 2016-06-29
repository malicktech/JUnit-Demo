package com.agilidee.livrejunit.servlet;

import org.junit.*;

import static org.junit.Assert.*;

import org.mortbay.jetty.testing.HttpTester;
import org.mortbay.jetty.testing.ServletTester;


public class ServletDeCalculTest {
    private ServletTester tester;
    private String baseUrl;

    @Before
    public void setUpClass() throws Exception
    {
        tester = new ServletTester();
        tester.setContextPath("/");
        tester.addServlet(ServletDeCalcul.class, "/servletdecalcul");
        baseUrl = tester.createSocketConnector(true);
        tester.start();
    }

    @After
    public void tearDownClass() throws Exception
    {
        tester.stop();
    }


    @Test
    public void testPGCD () throws Exception
    {
        testeJeuDeValeurs ("pgcd",new Long(18),new Long(30), new Long(6));
        testeJeuDeValeurs ("pgcd",new Long(12),new Long(15), new Long(3));
    }

    @Test
    public void testPPCM () throws Exception
    {
        testeJeuDeValeurs ("ppcm",new Long(15),new Long(10), new Long(30));
        testeJeuDeValeurs ("ppcm",new Long(30),new Long(24), new Long(120));
    }

    private void testeJeuDeValeurs (String operation, Long a, Long b, Long resultat)  throws Exception {
        HttpTester requete = genererGetRequest(operation, a, b);
        String resultatAttendu = "{\"resultat\":"+resultat.toString()+"}";

        HttpTester reponse = new HttpTester();
        reponse.parse(tester.getResponses(requete.generate()));
        
        assertEquals(200,reponse.getStatus());
        assertEquals(resultatAttendu, reponse.getContent().trim());
    }

    private HttpTester genererGetRequest(String operation, Long a, Long b) {
        HttpTester getRequest = new HttpTester();
        getRequest.setMethod("GET");
        getRequest.setURI("/servletdecalcul?a="+a.toString()
                            +"&b="+b.toString()
                            +"&operation="+operation);
        getRequest.setVersion("HTTP/1.0");
        return getRequest;
    }
}