package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"123"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected).isEqualTo(123);
    }

    @Test
    void whenManyValidInput() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"o", "12", "1"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected).isEqualTo(12);
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}
