package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenExit() {
        Input input = new StubInput(
                new String[]{"0"}
        );
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
        );
    }
}