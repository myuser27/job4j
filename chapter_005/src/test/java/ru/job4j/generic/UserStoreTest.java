package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class UserStoreTest {

    @Test
    public void addAndFindByIdTest() {
        UserStore users = new UserStore(2);
        users.add(new User("1", "Name1"));
        users.add(new User("2", "Name2"));
        assertThat(users.findById("1"), is(new User("1", "Name1")));
        assertThat(users.findById("2"), is(new User("2", "Name2")));
    }

    @Test
    public void replaceElementTrueTest() {
        UserStore users = new UserStore(2);
        users.add(new User("1", "Name1"));
        users.add(new User("2", "Name2"));
        assertThat(users.replace("1", new User("1", "Name3")),
                is(true));
    }

    @Test
    public void replaceElementFalseTest() {
        UserStore users = new UserStore(2);
        users.add(new User("1", "Name1"));
        users.add(new User("2", "Name2"));
        assertThat(users.replace("5", new User("1", "Name3")),
                is(false));
    }

    @Test
    public void deleteNotLastElementTrueTest() {
        UserStore users = new UserStore(4);
        users.add(new User("1", "Name1"));
        users.add(new User("2", "Name2"));
        users.add(new User("3", "Name3"));
        users.add(new User("4", "Name4"));
        assertThat(users.delete("2"), is(true));
    }

    @Test
    public void deleteLastElementTrueTest() {
        UserStore users = new UserStore(4);
        users.add(new User("1", "Name1"));
        users.add(new User("2", "Name2"));
        users.add(new User("3", "Name3"));
        users.add(new User("4", "Name4"));
        assertThat(users.delete("4"), is(true));
    }

    @Test
    public void deleteElementFalseTest() {
        UserStore users = new UserStore(4);
        users.add(new User("1", "Name1"));
        users.add(new User("2", "Name2"));
        users.add(new User("3", "Name3"));
        users.add(new User("4", "Name4"));
        assertThat(users.delete("6"), is(false));
    }
}