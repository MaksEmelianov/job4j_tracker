package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {

    @Test
    void whenAddNewItemThenTrackerHasSameItem() {
        Store tracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    void whenTestFindAll() {
        Store tracker = new MemTracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        Item result1 = tracker.findAll().get(0);
        Item result2 = tracker.findAll().get(1);
        assertThat(result1.getName()).isEqualTo(item1.getName());
        assertThat(result2.getName()).isEqualTo(item2.getName());
    }

    @Test
    void whenTestFindByNameCheckArrayLength() {
        Store tracker = new MemTracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        tracker.add(new Item("Item1"));
        List<Item> result = tracker.findByName(item1.getName());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void whenTestFindByNameCheckSecondNameItem() {
        Store tracker = new MemTracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        tracker.add(new Item("Item1"));
        List<Item> result = tracker.findByName(item2.getName());
        assertThat(result.get(0).getName()).isEqualTo(item2.getName());
    }

    @Test
    void whenReplace() {
        Store tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    void whenDeleteOneItem() {
        Store tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    void whenDeleteTwoItems() {
        Store tracker = new MemTracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        int id = item1.getId();
        tracker.delete(id);
        assertThat(tracker.findAll().get(0)).isEqualTo(item2);
    }

    @Test
    void whenDeleteThreeItems() {
        Store tracker = new MemTracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        Item item3 = new Item("Item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        int id = item1.getId();
        tracker.delete(id);
        assertThat(tracker.findAll().get(1)).isEqualTo(item3);
    }

    @Test
    void whenTestFindAllAscSort() {
        var time = LocalDateTime.now();
        List<Item> items = new ArrayList<>(
                List.of(
                new Item("Item3", time),
                new Item("Item2", time),
                new Item("Item5", time),
                new Item("Item6", time)
        ));
        items.sort(new ItemAscByName());
        List<Item> expected = List.of(
                new Item("Item2", time),
                new Item("Item3", time),
                new Item("Item5", time),
                new Item("Item6", time));
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenTestFindAllDescSort() {
        var time = LocalDateTime.now();
        List<Item> items = new ArrayList<>(
                List.of(
                new Item("Item3", time),
                new Item("Item2", time),
                new Item("Item5", time),
                new Item("Item6", time)
        ));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>(
                List.of(
                        new Item("Item6", time),
                        new Item("Item5", time),
                        new Item("Item3", time),
                        new Item("Item2", time)
                ));
        assertThat(items).isEqualTo(expected);
    }
}