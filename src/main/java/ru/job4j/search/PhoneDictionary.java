package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> combine0 = (person) ->  person.getPhone().contains(key);
        Predicate<Person> combine1 = (person) ->  person.getAddress().contains(key);
        Predicate<Person> combine2 = (person) ->  person.getSurname().contains(key);
        Predicate<Person> combine3 = (person) ->  person.getName().contains(key);
        Predicate<Person> combine =
                combine0
                .or(combine1)
                .or(combine2)
                .or(combine3);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
