package demo2_testhelpers;

import testhelpers.EqualsHashCodeTestCase;

import org.junit.Test;

import demo2_testhelpers.App;

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
