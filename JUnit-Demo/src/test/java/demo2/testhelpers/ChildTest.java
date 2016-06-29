package demo2.testhelpers;

import org.junit.Before;
import org.junit.Test;

import demo2.testhelpers.Child;

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
