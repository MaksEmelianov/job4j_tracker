package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {
    @Test
    void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        Item result1 = tracker.findAll()[0];
        Item result2 = tracker.findAll()[1];
        assertThat(result1.getName()).isEqualTo(item1.getName());
        assertThat(result2.getName()).isEqualTo(item2.getName());
    }

    @Test
    void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        tracker.add(new Item("Item1"));
        Item[] result = tracker.findByName(item1.getName());
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    void whenTestFindByNameCheckSecondNameItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        tracker.add(new Item("Item1"));
        Item[] result = tracker.findByName(item2.getName());
        assertThat(result[0].getName()).isEqualTo(item2.getName());
    }
}