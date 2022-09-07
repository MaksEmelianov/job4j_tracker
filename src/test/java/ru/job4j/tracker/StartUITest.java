package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        String[] answers = {"item1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.creatItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("item1");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("item1");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "item2"};
        StartUI.editItem(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName()).isEqualTo("item2");
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1");
        tracker.add(item1);
        String[] answers = {String.valueOf(item1.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item1.getId());
        assertThat(deleted).isNull();
    }
}