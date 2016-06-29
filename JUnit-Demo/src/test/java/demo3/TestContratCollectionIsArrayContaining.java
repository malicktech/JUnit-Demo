package demo3;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class TestContratCollectionIsArrayContaining {

	@Test
    public void contientElementContrat() {
        assertThat(new Long[]{1L, null}, hasItemInArray(nullValue()));
    }

    @Test
    public void neContientPasElementContrat() {
        assertThat(new Long[]{1L, 2L}, hasItemInArray(nullValue()));
    }

    @Test
    public void contientElement() {
        assertThat(new Long[]{1L, 2L}, hasItemInArray(1L));
    }

    @Test
    public void neContientPasElement() {
        assertThat(new Long[]{1L, 2L}, hasItemInArray(3L));
    }
    
}
