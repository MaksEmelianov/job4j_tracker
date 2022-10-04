package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {

    @Test
    void whenCheckFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "+79999999999", "RF")
        );
        ArrayList<Person> persons = phones.find("Ivan");
        assertThat(persons.get(0).getSurname()).isEqualTo("Ivanov");
    }

    @Test
    void whenCheckFindBySurName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Petrov", "+79999999999", "RF")
        );
        phones.add(
                new Person("Stas", "Ivanov", "+79999999999", "RF")
        );
        ArrayList<Person> persons = phones.find("Ivanov");
        assertThat(persons.get(0).getName()).isEqualTo("Stas");
    }

    @Test
    void whenNoFindBPersonByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Petrov", "+79999999999", "RF"));
        ArrayList<Person> persons = phones.find("Misha");
        assertThat(persons.isEmpty()).isTrue();
    }

    @Test
    void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }
}
