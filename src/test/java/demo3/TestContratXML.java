package demo3;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasXPath;
import static org.junit.Assert.assertThat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestContratXML {

    private Document document;

    @Before
    public void initialise() throws ParserConfigurationException {
        final DocumentBuilderFactory lDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder lDocumentBuilder = lDocumentBuilderFactory.newDocumentBuilder();

        document = lDocumentBuilder.newDocument();

        final Element lElement = document.createElement("racine");
        document.appendChild(lElement);

        final Element lElement1 = document.createElement("element1");
        lElement1.appendChild(document.createTextNode("texteElement1"));
        lElement.appendChild(lElement1);
        final Element lElement2 = document.createElement("element2");
        lElement2.appendChild(document.createTextNode("texteElement2"));
        lElement.appendChild(lElement2);
    }
    
    @Test
    public void avecChemin() {
        assertThat(document, hasXPath("/racine/element1"));
    }
    
    @Test
    public void sansChemin() {
        assertThat(document, hasXPath("/racine/element3"));
    }
    
    @Test
    public void avecCheminContrat() {
        assertThat(document, hasXPath("/racine/element1", equalToIgnoringCase("texteelement1")));
    }
    
    @Test
    public void sansCheminContrat() {
        assertThat(document, hasXPath("/racine/element1", equalToIgnoringCase("texteelement2")));
    }
}
