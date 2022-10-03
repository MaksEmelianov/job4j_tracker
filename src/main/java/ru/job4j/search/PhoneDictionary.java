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
        Predicate<Person> cmbPhone = (person) ->  person.getPhone().contains(key);
        Predicate<Person> cmbAddress = (person) ->  person.getAddress().contains(key);
        Predicate<Person> cmbSurname = (person) ->  person.getSurname().contains(key);
        Predicate<Person> cmbName = (person) ->  person.getName().contains(key);
        Predicate<Person> combine =
                cmbPhone
                .or(cmbAddress)
                .or(cmbSurname)
                .or(cmbName);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
