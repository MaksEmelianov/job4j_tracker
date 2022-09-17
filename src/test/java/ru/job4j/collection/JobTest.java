package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Job3", 0),
                new Job("Job1", 0),
                new Job("Job2", 0)
        );
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Job1", 0),
                new Job("Job2", 0),
                new Job("Job3", 0)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByNameLn() {
        List<Job> jobs = Arrays.asList(
                new Job("Job", 0),
                new Job("Jb", 0),
                new Job("J", 0)
        );
        jobs.sort(new JobAscByNameLn());
        List<Job> expected = Arrays.asList(
                new Job("J", 0),
                new Job("Jb", 0),
                new Job("Job", 0)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug", 1),
                new Job("Fix bug", 2),
                new Job("Fix bug", 4)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Job3", 0),
                new Job("Job1", 0),
                new Job("Job2", 0)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Job3", 0),
                new Job("Job2", 0),
                new Job("Job1", 0)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByNameLn() {
        List<Job> jobs = Arrays.asList(
                new Job("Jb", 0),
                new Job("Job12", 0),
                new Job("Jb2", 0)
        );
        jobs.sort(new JobDescByNameLn());
        List<Job> expected = Arrays.asList(
                new Job("Job12", 0),
                new Job("Jb2", 0),
                new Job("Jb", 0)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Job1", 0),
                new Job("Job2", 1),
                new Job("Job3", 2)
        );
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Job3", 2),
                new Job("Job2", 1),
                new Job("Job1", 0)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenComparatorAscByNameAndPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Job1", 0),
                new Job("Job3", 2),
                new Job("Job3", 1),
                new Job("Job2", 0)
        );
        jobs.sort(new JobAscByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = Arrays.asList(
                new Job("Job1", 0),
                new Job("Job2", 0),
                new Job("Job3", 1),
                new Job("Job3", 2)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenComparatorAscByNameLnAndNameAndPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Job0", 1),
                new Job("Job", 0),
                new Job("Job2", 0),
                new Job("Job1", 0)
        );
        jobs.sort(new JobAscByNameLn()
                .thenComparing(new JobAscByName()
                        .thenComparing(new JobAscByPriority()))
        );
        List<Job> expected = Arrays.asList(
                new Job("Job", 0),
                new Job("Job0", 1),
                new Job("Job1", 0),
                new Job("Job2", 0)
        );
        assertThat(jobs).isEqualTo(expected);
    }
}
