package demo2_testhelpers;

import org.junit.Before;
import org.junit.Test;

import demo2_testhelpers.Child;

public class ChildTest {

    private Child child;

    @Before
    public void setUp()
            throws Exception {

        child = new Child();

    }

    @Test
    public void testing() {

        child.moreStuff();
    }
}
