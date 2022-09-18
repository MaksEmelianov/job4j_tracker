package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LexSortTest {

    @Test
    void whenSortNums1and2and10() {
        String[] in = {
                "10. Task",
                "2. Task",
                "1. Task"
        };
        String[] out = {
                "1. Task",
                "2. Task",
                "10. Task"
        };
        Arrays.sort(in, new LexSort());
        assertThat(in).containsExactly(out);
    }
}
