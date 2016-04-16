package demo3;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestContratNumber {

    @Test
    public void proche() {
        assertThat(20.5, closeTo(20, 0.5));
    }

    @Test
    public void pasProche() {
        assertThat(20.5, closeTo(20, 0.1));
    }

    @Test
    public void plusGrand() {
        assertThat(21, greaterThan(20));
    }

    @Test
    public void pasPlusGrand() {
        assertThat(20, greaterThan(20));
    }

    @Test
    public void plusGrandOuEgal() {
        assertThat(20, greaterThanOrEqualTo(20));
    }

    @Test
    public void pasPlusGrandOuEgal() {
        assertThat(19, greaterThanOrEqualTo(20));
    }

    @Test
    public void plusPetit() {
        assertThat(19, lessThan(20));
    }

    @Test
    public void pasPlusPetit() {
        assertThat(20, lessThan(20));
    }

    @Test
    public void plusPetitOuEgal() {
        assertThat(20, lessThanOrEqualTo(20));
    }

    @Test
    public void pasPlusPetitOuEgal() {
        assertThat(21, lessThanOrEqualTo(20));
    }
}