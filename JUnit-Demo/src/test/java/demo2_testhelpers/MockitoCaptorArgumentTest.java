package demo2_testhelpers;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo2_testhelpers.Sample;
import demo2_testhelpers.SampleImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Class to...
 *
 * @author chas
 *         Date: 16/02/13
 */
public class MockitoCaptorArgumentTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MockitoCaptorArgumentTest.class);

    @Test
    public void doSomeChecksWithAnswer() {
        final Sample sample = mock(Sample.class);
        ArgumentMatcher<Sample> matches = new ArgumentMatcher<Sample>() {
            @Override
            public boolean matches(final Object argument) {
                assertEquals("Wrong name", "name", ((Sample) argument).getName());
                return true;
            }
        };

        final Sample other = new SampleImpl();
        other.setName("name");
        sample.setOtherSample(other);
        verify(sample).setOtherSample(argThat(matches));
    }

    @Test
    public void doSomeChecksWithCaptor() {
        final Sample sample = mock(Sample.class);
        when(sample.getName()).thenReturn("myName");
        final Sample other = new SampleImpl();
        other.setName("name");
        sample.setOtherSample(other);
        final ArgumentCaptor<Sample> argumentCaptor =
                ArgumentCaptor.forClass(Sample.class);
        verify(sample).setOtherSample(argumentCaptor.capture());
        assertEquals("Wrong name", "name", argumentCaptor.getValue().getName());
    }
}
