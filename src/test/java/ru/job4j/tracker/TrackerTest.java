package ru.job4j.tracker;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        Item result1 = tracker.findAll().get(0);
        Item result2 = tracker.findAll().get(1);
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
        List<Item> result = tracker.findByName(item1.getName());
        assertThat(result.size()).isEqualTo(3);
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
        List<Item> result = tracker.findByName(item2.getName());
        assertThat(result.get(0).getName()).isEqualTo(item2.getName());
    }

    @Test
    void whenReplace() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    void whenDeleteTwoItems() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
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
        List<Item> items = new ArrayList<>(
                List.of(
                new Item("Item3"),
                new Item("Item2"),
                new Item("Item5"),
                new Item("Item6")
        ));
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>(
                List.of(
                        new Item("Item2"),
                        new Item("Item3"),
                        new Item("Item5"),
                        new Item("Item6")
                ));
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenTestFindAllDescSort() {
        List<Item> items = new ArrayList<>(
                List.of(
                new Item("Item3"),
                new Item("Item2"),
                new Item("Item5"),
                new Item("Item6")
        ));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>(
                List.of(
                        new Item("Item6"),
                        new Item("Item5"),
                        new Item("Item3"),
                        new Item("Item2")
                ));
        assertThat(items).isEqualTo(expected);
    }
}