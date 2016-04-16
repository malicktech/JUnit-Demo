package demo3;

import org.junit.Assert;
import org.junit.Test;

public class TestTableau {

	/* assertions d'égalité pour les tableaux de */
	
	
	@Test 
    public void tableauAvecMemesValeurs() {
        final Boolean[] lResutat = Operations.pythagore(
                new long[]{3, 4, 5}, 
                new long[]{6, 10, 8}
        );
        Assert.assertArrayEquals(new Boolean[]{true, true}, lResutat);
    }

    @Test 
    public void tableauAvecValeursDifferentes() {
        final Boolean[] lResutat = Operations.pythagore(
                new long[]{3, 4, 6}, 
                new long[]{6, 11, 8}
        );
        Assert.assertArrayEquals(new Boolean[]{true, true}, lResutat);
    }
}
