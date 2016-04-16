package demo3;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

public class TestContratCollectionIsMapContaining {

    private Map<String, Long> hashMap;
    
    @Before
    public void initialise() {
        hashMap = new HashMap<String, Long>();
        hashMap.put("cle1", 1L);
        hashMap.put("cle2", 2L);
    }
    
    @Test
    public void contientEntree() {
        assertThat(hashMap, hasEntry("cle1", 1L));
    }

    @Test
    public void neContientPasEntree() {
        assertThat(hashMap, hasEntry("cle1", 2L));
    }

    @Test
    public void contientEntreeContrat() {
        assertThat(hashMap, hasEntry(is("cle1"), not(2L)));
    }

    @Test
    public void neContientPasEntreeContrat() {
        assertThat(hashMap, hasEntry(is("cle1"), not(1L)));
    }

    @Test
    public void contientCle() {
        assertThat(hashMap, IsMapContaining.hasKey("cle1"));
    }

    @Test
    public void neContientPasCleEntree() {
        assertThat(hashMap, IsMapContaining.hasKey("cle3"));
    }

    @Test
    public void contientCleContrat() {
        assertThat(hashMap, IsMapContaining.hasKey(is("cle1")));
    }

    @Test
    public void neContientPasCleContrat() {
        assertThat(hashMap, IsMapContaining.hasKey(is("cle3")));
    }

    @Test
    public void contientValeur() {
        assertThat(hashMap, IsMapContaining.hasValue(1L));
    }

    @Test
    public void neContientPasValeur() {
        assertThat(hashMap, IsMapContaining.hasValue(3L));
    }

    @Test
    public void contientValeurContrat() {
        assertThat(hashMap, IsMapContaining.hasValue(is(1L)));
    }

    @Test
    public void neContientPasValeurContrat() {
        assertThat(hashMap, IsMapContaining.hasValue(is(3L)));
    }
}