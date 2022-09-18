package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenExit() {
        Input input = new StubInput(
                new String[]{"0"}
        );
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        String newName = "New Item";
        Item item = tracker.add(new Item("Item"));
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), newName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(output),
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    void whenFindAllActionTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("Item1"));
        Input input = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindAllAction(output),
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    void whenFindByNameActionTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item2 = tracker.add(new Item("Item2"));
        Input input = new StubInput(
                new String[]{"0", item2.getName(), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(output),
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + item2 + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    void whenFindByIdActionTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item2 = tracker.add(new Item("Item2"));
        Input input = new StubInput(
                new String[]{"0", String.valueOf(item2.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(output),
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + item2 + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"1", "0"}
        );
        List<UserAction> actions = List.of(
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }
}