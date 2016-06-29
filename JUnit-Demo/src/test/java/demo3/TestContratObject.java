package demo3;

import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestContratObject {

    @Test
    public void toStringOK() {
        assertThat(new Long(30), hasToString(is("30")));
    }

    @Test
    public void toStringNOK() {
        assertThat(new Long(30), hasToString(is(" 30")));
    }

    @Test
    public void compatible() {
        assertThat(Long.class, typeCompatibleWith(Number.class));
    }

    @Test
    public void incompatible() {
        assertThat(Long.class, typeCompatibleWith(String.class));
    }
}