package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {

    public static void main(String[] args) {
        List<Job> jobList = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobList);
        Collections.sort(jobList);
        System.out.println(jobList);
        Collections.sort(jobList, new SortByNameJob());
        /*jobList.sort(new SortByNameJob());*/
        System.out.println(jobList);
        jobList.sort(new SortDescByNameJob());
        System.out.println(jobList);
    }
}
