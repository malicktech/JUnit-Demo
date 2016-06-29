package demo3;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class TestContratCollectionIsCollectionContaining {

    @Test
    public void contientElementContrat() {
        assertThat(Arrays.asList(1L, 2L), hasItem(is(1L)));
    }

    @Test
    public void neContientPasElementContrat() {
        assertThat(Arrays.asList(3L, 2L), hasItem(is(1L)));
    }

    @Test
    public void contientElementsContrat() {
        assertThat(Arrays.asList(1L, 2L), hasItems(is(1L), is(2L)));
    }

    @Test
    public void neContientPasElementsContrat() {
        assertThat(Arrays.asList(1L, null), hasItems(is(1L), is(2L)));
    }

    @Test
    public void contientElement() {
        assertThat(Arrays.asList(1L, 2L), hasItem(1L));
    }

    @Test
    public void neContientPasElement() {
        assertThat(Arrays.asList(1L, 2L), hasItem(3L));
    }

    @Test
    public void contientElements() {
        assertThat(Arrays.asList(1L, 2L), hasItems(1L, 2L));
    }

    @Test
    public void neContientPasElements() {
        assertThat(Arrays.asList(1L, 2L), hasItems(1L, 2L, 3L));
    }
}
