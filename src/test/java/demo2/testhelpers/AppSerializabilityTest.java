package demo2.testhelpers;

import demo2.testhelpers.App;
import testhelpers.SerializabilityTestCase;

import java.io.Serializable;

public class AppSerializabilityTest extends SerializabilityTestCase {
    @Override
    protected Serializable createInstance() throws Exception {
        return new App("FFF");
    }
}
