package demo3;

import static org.hamcrest.Matchers.eventFrom;
import static org.junit.Assert.assertThat;

import java.beans.PropertyChangeEvent;

import javax.swing.event.ChangeEvent;

import org.junit.Before;
import org.junit.Test;

public class TestContratObjectIsEventFrom {

    private Object source;
    private ChangeEvent event;

    @Before
    public void initialise() {
        source = "source";
        event = new ChangeEvent(source);
    }

    @Test
    public void envementOrigine() {
        assertThat(event, eventFrom(source));
    }

    @Test
    public void envenementAutreOrigine() {
        assertThat(event, eventFrom("autreSource"));
    }

    @Test
    public void evenementClasse() {
        assertThat(event, eventFrom(ChangeEvent.class, source));
    }

    @Test
    public void evenementAutreClasse() {
        assertThat(event, eventFrom(PropertyChangeEvent.class, source));
    }

}