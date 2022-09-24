package ru.job4j.collection;

import java.util.*;
import java.util.function.Function;

public class JobSorter {

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        System.out.println(jobs);
        Comparator<Job> compareNameLn = Comparator.comparingInt((job) -> job.getName().length());
        Comparator<Job> compareName = Comparator.comparing(Job::getName);
        Comparator<Job> comparePriority = Comparator.comparingInt(Job::getPriority);
        Comparator<Job> comparator = compareNameLn
                .thenComparing(compareName
                        .thenComparing(comparePriority));
        jobs.sort(comparator);
        System.out.println(jobs);
        /*
        Comparator<Job> comb = new JobDescByNameLn()
                                    .thenComparing(new JobDescByName())
                                    .thenComparing(new JobDescByPriority());
        Collections.sort(jobs, comb);
        jobs.sort(
                new JobDescByNameLn()
                        .thenComparing(new JobDescByName())
                        .thenComparing(new JobDescByPriority())
        );
        */
    }
}
