package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueTextTest {

    @Test
    void whenIsEqualsTrue() {
        boolean rsl = UniqueText.isEquals(
                new String("test1 test2 test3"),
                new String("test1 test2 test3")
        );
        assertThat(rsl).isTrue();
    }

    @Test
    void whenIsEqualsFalse() {
        boolean rsl = UniqueText.isEquals(
                new String("test1 test2 test3"),
                new String("test1 test test3")
        );
        assertThat(rsl).isFalse();
    }
}
