package demo2_testhelpers;

import testhelpers.SerializabilityTestCase;

import java.io.Serializable;

import demo2_testhelpers.App;

public class AppSerializabilityTest extends SerializabilityTestCase {
    @Override
    protected Serializable createInstance() throws Exception {
        return new App("FFF");
    }
}
