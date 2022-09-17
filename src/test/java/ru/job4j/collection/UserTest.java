package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Ivan", 54));
        users.add(new User("Artem", 10));
        Iterator<User> iterator = users.iterator();
        assertThat(iterator.next()).isEqualTo(new User("Artem", 10));
        assertThat(iterator.next()).isEqualTo(new User("Ivan", 54));
    }

    @Test
    void whenAscForUsersWithEqualNameButDifferentAge() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 35));
        users.add(new User("Ivan", 31));
        users.add(new User("Petr", 25));
        users.add(new User("Ivan", 29));
        users.add(new User("Petr", 33));
        users.add(new User("Ivan", 27));
        Set<User> expected = new TreeSet<>(
                Arrays.asList(
                        new User("Ivan", 27),
                        new User("Ivan", 29),
                        new User("Ivan", 31),
                        new User("Petr", 25),
                        new User("Petr", 33),
                        new User("Petr", 35)
                )
        );
        assertThat(users).containsAll(expected);
    }

    @Test
    void whenComparePetrVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 23)
                );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenComparePetrVSPetrWithDifferentAge() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Petr", 54)
                );
        assertThat(rsl).isLessThan(0);
    }
}
