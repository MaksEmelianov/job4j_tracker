package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertListTest {
    @Test
    void whenConvertToList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[]{1, 2, 3});
        in.add(new int[]{1, 2});
        in.add(new int[]{1});
        List<Integer> out = ConvertList.convert(in);
        List<Integer> expected = Arrays.asList(1, 2, 3, 1, 2, 1);
        assertThat(out).containsAll(expected);
    }
}
