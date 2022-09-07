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
}