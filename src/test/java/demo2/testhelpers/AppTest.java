package demo2.testhelpers;

import com.google.common.base.CharMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

public class AppTest {

    @Ignore("Test is ignored as a demonstration")
    @Test
    public void testSane() {
        assertThat(1, is(1));
    }

    @Test
    public void testCharMatcher() {
        assertThat("shouldn't match XYZ in anything", CharMatcher.noneOf("XYZ").matchesAnyOf("anything"));
    }

    @Test
    public void testChainAllOfMatchers() {
        assertThat(" Hello ",
                is(allOf(notNullValue(), instanceOf(String.class), equalToIgnoringWhiteSpace("Hello"), endsWith("lo "))));
    }

    @Test
    public void allOfExampleShowsAllMatchersMustAllBeTrue() throws Exception {
        assertThat("Hello", is(allOf(notNullValue(), instanceOf(String.class), equalTo("Hello"))));
    }

    @Test
    public void allOfExampleShowsFailingIfOneMatcherDoesNotMatch() throws Exception {
        assertThat("Hello", is(not(allOf(notNullValue(), instanceOf(Integer.class)))));
    }

    @Test
    public void anyExampleChecksThatClassIsOfSameType() throws Exception {
        assertThat("Hello", is(any(String.class)));
    }

    @Test
    public void anyExampleShowsStringIsAlsoAnObject() throws Exception {
        assertThat("Hello", is(any(Object.class)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void anyOfExampleReturnsTrueIfOneMatches() throws Exception {
        assertThat("Hello", is(anyOf(nullValue(), instanceOf(String.class), equalTo("Goodbye"))));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void anyOfExampleFailingIfAllMatchersAreFalse() throws Exception {
        assertThat("Hello", is(not(anyOf(nullValue(), instanceOf(Integer.class), equalTo("Goodbye")))));
    }

    @Test
    public void anythingExampleAlwaysReturnsTrue() throws Exception {
        assertThat("Hello", is(anything()));
    }

    // Feels very esoteric and not for typical usage used to override the
    // description
    @Test
    public void describedAsExample() throws Exception {
        Matcher<?> matcher = describedAs("My Description", anything());
        Description description = new StringDescription().appendDescriptionOf(matcher);
        assertThat("My Description", is(description.toString()));
    }

    @Test
    public void equalToExampleAddingTwoPlusTwo() throws Exception {
        assertThat(2 + 2, is(equalTo(4)));
    }

    @Test
    public void instanceOfExampleForString() throws Exception {
        assertThat("Hello", is(instanceOf(String.class)));
    }

    @Test
    public void isExampleShortCutForIsInstanceOfClass() throws Exception {
        assertThat("Hello", isA(String.class));
        assertThat("Hello", instanceOf(String.class));
    }

    @Test
    public void isExampleShortCutAsJustSyntacticSugarUsedThreeTimes() throws Exception {
        assertThat("Hello", is(is(is(notNullValue()))));
    }

    @Test
    public void isExampleShortCutForIsEqualTo() throws Exception {
        assertThat("Hello", is("Hello"));
        assertThat("Hello", equalTo("Hello"));
    }

    @Test
    public void notExampleJustInvertsExpression() throws Exception {
        assertThat("Hello", is(not(instanceOf(Integer.class))));
    }

    @Test
    public void notNullValueExampleForString() throws Exception {
        assertThat("Hello", is(notNullValue()));
    }

    @Test
    public void notNullValueExampleForAClass() throws Exception {
        assertThat("Hello", is(notNullValue(Object.class)));
    }

    @Test
    public void nullValueExampleWithANull() throws Exception {
        assertThat(null, is(nullValue()));
    }

    @Test
    public void nullValueExampleWithANullType() throws Exception {
        Integer nothing = null;
        assertThat(nothing, is(nullValue(Integer.class)));
    }

    @Test
    public void sameInstanceExample() throws Exception {
        Object object = new Object();
        Object sameObject = object;
        assertThat(object, is(sameInstance(sameObject)));
    }
}
