package com.agilidee.livrejunit.servlet;

import com.clarkware.junitperf.*;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TimedTests {

    protected static TestSuite makeTestSuite() {
        JUnit4TestAdapter unit4TestAdapter = new JUnit4TestAdapter(ServletDeCalculTest.class);

        long maxElapsedTime = 10;
        Test timedTest = new TimedTest(unit4TestAdapter, maxElapsedTime);

        int maxUsers = 10;
        Test loadTest = new LoadTest(unit4TestAdapter, maxUsers);

        TestSuite testSuite = new TestSuite("TimedTests");
        testSuite.addTest(timedTest);
        testSuite.addTest(loadTest);
        return testSuite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(makeTestSuite());
    }
}