package demo3;

import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class TestContratCollectionIsIn {

    @Test
    public void presentDansCollection() {
        assertThat("a", isIn(Arrays.asList("a", "z", "e", "r", "t", "y")));
    }

    @Test
    public void absentDeCollection() {
        assertThat("A", isIn(Arrays.asList("a", "z", "e", "r", "t", "y")));
    }

    @Test
    public void presentDansTableau() {
        assertThat("a", isIn(new String[]{"a", "z", "e", "r", "t", "y"}));
    }

    @Test
    public void absentDeTableau() {
        assertThat("A", isIn(new String[]{"a", "z", "e", "r", "t", "y"}));
    }

    @Test
    public void present() {
        assertThat("a", isOneOf("a", "z", "e", "r", "t", "y"));
    }

    @Test
    public void absent() {
        assertThat("A", isOneOf("a", "z", "e", "r", "t", "y"));
    }
}
