package ru.job4j.collection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCompareTest {

    @Test
    void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Zaycev",
                "Ivanova"
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void charOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivonova",
                "Ivanova"
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void charOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanova",
                "Ivonova"
        );
        assertThat(rsl).isLessThan(0);
    }
}
