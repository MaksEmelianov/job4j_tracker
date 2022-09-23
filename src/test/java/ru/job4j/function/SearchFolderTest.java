package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchFolderTest {

    @Test
    void whenFilterSize() {
        List<Folder> folderList = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(new Folder("fix", 110));
        Predicate<Folder> predicate = f -> f.getSize() > 100;
        List<Folder> result = SearchFolder.filter(folderList, predicate);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenFilterName() {
        List<Folder> folderList = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        Predicate<Folder> predicate = f -> f.getName().contains("bug");
        List<Folder> result = SearchFolder.filter(folderList, predicate);
        assertThat(result).containsAll(expected);
    }
}
