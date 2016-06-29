package demo2.testhelpers;

import demo2.testhelpers.App;
import testhelpers.ComparabilityTestCase;

public class AppComparabilityTest extends ComparabilityTestCase<App> {
	@Override
	protected App createLessInstance() throws Exception {
		return new App("AAA");
	}

	@Override
	protected App createEqualInstance() throws Exception {
		return new App("FFF");
	}

	@Override
	protected App createGreaterInstance() throws Exception {
		return new App("ZZZ");
	}
}
