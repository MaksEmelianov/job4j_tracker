package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreatItem() {
        Input input = new StubInput(
                new String[]{"0", "New Item", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new Exit()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("New Item");
    }

    @Test
    void whenReplaceAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        String newName = "NewName";
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), newName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new Exit()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(newName);
    }

    @Test
    void whenDeleteAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new Exit()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}