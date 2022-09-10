package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

    @Test
    void whenValid() {
        String in = "admiiiiiiiiI1n!";
        String out = PasswordValidator.validate(in);
        String expected = "Пароль валидный";
        assertThat(out).isEqualTo(expected);
    }

    @Test
    void whenInValidNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль пуст");
    }

    @Test
    void whenInValidEmpty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль пуст");
    }

    @Test
    void whenInValidLength() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("pass");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль несоответсвует шаблону длины: 8 - 32 символа");
    }

    @Test
    void whenInValidLightPass() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("admin");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль слишком легкий");
    }

    @Test
    void whenInValidNotLowerCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("DFSBBDBDBDBDB1!");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Добавьте в пароль хотя бы одну строчную будку");
    }

    @Test
    void whenInValidNotUpperCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("dsfbdfbdbdd1!");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Добавьте в пароль хотя бы одну прописную будку");
    }

    @Test
    void whenInValidNotDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("vsvsdvsvsdv!N");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Добавьте в пароль хотя бы одну цифру");
    }

    @Test
    void whenInValidNotLetterOrDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("sdvsdvsdsvsdvdsS1");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Добавьте в пароль хотя бы однин спец. знак");
    }
}
