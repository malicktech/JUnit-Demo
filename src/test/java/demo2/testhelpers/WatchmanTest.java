package demo2.testhelpers;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class WatchmanTest {
    private static String watchedLog;
    @Rule
    public TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            // TODO Auto-generated method stub
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            watchedLog += description.getDisplayName() + " " + "success!\n";
        }

        @Override
        protected void failed(Throwable e, Description description) {
            watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
        }
    };
}