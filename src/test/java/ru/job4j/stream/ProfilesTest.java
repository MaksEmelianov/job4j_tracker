package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfilesTest {

    @Test
    void whenTestMethodCollect() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        List<Profile> profileList = List.of(
                new Profile(first),
                new Profile(second),
                new Profile(third)
        );
        List<Address> result = Profiles.collect(profileList);
        List<Address> expected = List.of(first, second, third);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenTestMethodCollectSortWithoutDuplicate() {
        Address first = new Address("City3", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City1", "Street3", 3, 3);
        Address fourth = new Address("City1", "Street1", 1, 1);
        Address fifth = new Address("City2", "Street2", 2, 2);
        Address seventh = new Address("City3", "Street3", 3, 3);
        List<Profile> profileList = List.of(
                new Profile(second),
                new Profile(fourth),
                new Profile(fifth),
                new Profile(first),
                new Profile(seventh),
                new Profile(third)
        );
        List<Address> result = Profile.collectSortWithoutDuplicate(profileList);
        List<Address> expected = List.of(
                first,
                second,
                third
        );
        assertThat(result).containsAll(expected);
    }
}
