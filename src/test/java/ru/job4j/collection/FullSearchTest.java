package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearchTest {

    @Test
    void extractNumber() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "Task1"),
                new Task("2", "Task2"),
                new Task("1", "Task1")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSearch.extractNumber(tasks)).containsAll(expected);
    }
}
