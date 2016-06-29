package demo2.testhelpers;

import demo2.testhelpers.App;
import testhelpers.EqualsHashCodeTestCase;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppEqualsHashCodeTest extends EqualsHashCodeTestCase {
    @Override
    protected App createInstance() throws Exception {
        return new App("aa");
    }

    @Override
    protected App createNotEqualInstance() throws Exception {
        return new App("ZZ");
    }

    @Test
    public void testAssertTrue() {
        assertTrue(true);
    }
}
