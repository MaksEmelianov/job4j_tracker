package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NotifyAccountTest {

    @Test
    void when3AccountsAddSent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Maks", "123"),
                new Account("321", "Ivan", "312"),
                new Account("123", "Maks", "999")
        );
        HashSet<Account> expected = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Maks", "123"),
                        new Account("321", "Ivan", "312")
                )
        );
        assertThat(NotifyAccount.sent(accounts)).containsAll(expected);
    }

    @Test
    void whenTwoAccountsAddSent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts)).containsAll(expect);
    }
}
