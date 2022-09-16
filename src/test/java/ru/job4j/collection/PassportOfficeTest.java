package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {

    @Test
    void whenTestAddAndGetMethods() {
        Citizen citizen = new Citizen("123456", "User1");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    void whenAddDoubleCitizen() {
        PassportOffice office = new PassportOffice();
        Citizen citizen1 = new Citizen("123456", "User1");
        Citizen citizen2 = new Citizen("123456", "User2");
        office.add(citizen1);
        assertThat(office.add(citizen2)).isFalse();
    }
}
