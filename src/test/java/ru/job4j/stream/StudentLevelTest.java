package ru.job4j.stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentLevelTest {

    @Test
    void whenSorted() {
        List<Student> in = List.of(
                new Student(28, "Masha"),
                new Student(128, "Pety")
        );
        List<Student> out = StudentLevel.levelOf(in, 20);
        List<Student> expected = List.of(
                new Student(128, "Pety"),
                new Student(28, "Masha")
        );
        assertThat(out).containsSequence(expected);
    }

    @Test
    void whenOnlyNull() {
        List<Student> in = new ArrayList<>();
        in.add(null);
        List<Student> out = StudentLevel.levelOf(in, 20);
        List<Student> expected = List.of();
        assertThat(out).containsAll(expected);
    }

    @Test
    void whenHasNull() {
        List<Student> in = new ArrayList<>();
        in.add(new Student(28, "Masha"));
        in.add(null);
        in.add(new Student(128, "Pety"));
        in.add(null);
        List<Student> out = StudentLevel.levelOf(in, 20);
        List<Student> expected = List.of(
                new Student(128, "Pety"),
                new Student(28, "Masha")
        );
        assertThat(out).containsSequence(expected);
    }
}
