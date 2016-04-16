package demo3;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestContratText {

    @Test
    public void egalCasse() {
        assertThat("azerty", equalToIgnoringCase("Azerty"));
    }

    @Test
    public void pasEgalCasse() {
        assertThat("azerty", equalToIgnoringCase("Qwerty"));
    }

    @Test
    public void egalEspace() {
        assertThat("a\nz e r t y", equalToIgnoringWhiteSpace("a  z  e  r \n t  y"));
    }

    @Test
    public void pasEgalEspace() {
        assertThat("a z e r t y", equalToIgnoringWhiteSpace("q w e r t y"));
    }

    @Test
    public void contient() {
        assertThat("azerty", containsString("zert"));
    }

    @Test
    public void neContientPas() {
        assertThat("azerty", containsString("wert"));
    }

    @Test
    public void commencePar() {
        assertThat("azerty", startsWith("azer"));
    }

    @Test
    public void neCommencePasPar() {
        assertThat("azerty", startsWith("qwer"));
    }

    @Test
    public void finitPar() {
        assertThat("azerty", endsWith("erty"));
    }

    @Test
    public void neFinitPasPar() {
        assertThat("azerty", endsWith("erti"));
    }
}