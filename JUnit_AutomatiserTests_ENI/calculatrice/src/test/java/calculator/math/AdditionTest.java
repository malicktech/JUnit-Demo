package calculator.math;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.math.Addition;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AdditionTest {
    Addition op;

    @Before
    public void setUp() {
        op = new Addition();
    }

    @After
    public void tearDown() {        
    }

    @Test
    public void testCalculer() throws Exception {
        assertThat(op.calculer(new Long(1),new Long(3)), is(new Long(4)));
    }

    @Test
    public void testLireSymbole() throws Exception {
        assertThat(op.lireSymbole(), is('+'));
    }
}
