package ru.job4j.set;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortUserTest {
    @Test
    public void whereDefaultSortUser() {
        List<User> users = List.of(
                new User("Ivan", 30),
                new User("Aleksei", 22),
                new User("El", 44),
                new User("Vladimir", 28),
                new User("El", 20));
        Set<User> expected = Set.of(
                new User("El", 20),
                new User("Aleksei", 22),
                new User("Vladimir", 28),
                new User("Ivan", 30),
                new User("El", 44));
        assertThat(new SortUser().sort(users), is(expected));
    }

    @Test
    public void whereNameLengthSortUser() {
        List<User> users = List.of(
                new User("Ivan", 30),
                new User("Aleksei", 22),
                new User("El", 44),
                new User("Vladimir", 28),
                new User("El", 20));
        List<User> expected = List.of(
                new User("El", 44),
                new User("El", 20),
                new User("Ivan", 30),
                new User("Aleksei", 22),
                new User("Vladimir", 28));
        assertThat(new SortUser().sortNameLength(users), is(expected));
    }

    @Test
    public void whereByAllFieldsSortUser() {
        List<User> users = List.of(
                new User("Ivan", 30),
                new User("Aleksei", 22),
                new User("El", 44),
                new User("Vladimir", 28),
                new User("El", 20));
        List<User> expected = List.of(
                new User("Aleksei", 22),
                new User("El", 20),
                new User("El", 44),
                new User("Ivan", 30),
                new User("Vladimir", 28));
        assertThat(new SortUser().sortByAllFields(users), is(expected));
    }
}
