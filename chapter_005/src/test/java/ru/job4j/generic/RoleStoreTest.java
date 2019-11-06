package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class RoleStoreTest {
    @Test
    public void addAndFindByIdTest() {
        RoleStore roles = new RoleStore(2);
        roles.add(new Role("1", "Role1"));
        roles.add(new Role("2", "Role2"));
        assertThat(roles.findById("1"), is(new Role("1", "Role1")));
        assertThat(roles.findById("2"), is(new Role("2", "Role2")));
    }

    @Test
    public void replaceElementTrueTest() {
        RoleStore roles = new RoleStore(2);
        roles.add(new Role("1", "Role1"));
        roles.add(new Role("2", "Role2"));
        assertThat(roles.replace("1", new Role("1", "Role3")),
                is(true));
    }

    @Test
    public void replaceElementFalseTest() {
        RoleStore roles = new RoleStore(2);
        roles.add(new Role("1", "Role1"));
        roles.add(new Role("2", "Role2"));
        assertThat(roles.replace("5", new Role("1", "Role3")),
                is(false));
    }

    @Test
    public void deleteNotLastElementTrueTest() {
        RoleStore roles = new RoleStore(4);
        roles.add(new Role("1", "Role1"));
        roles.add(new Role("2", "Role2"));
        roles.add(new Role("3", "Role3"));
        roles.add(new Role("4", "Role4"));
        assertThat(roles.delete("2"), is(true));
    }

    @Test
    public void deleteLastElementTrueTest() {
        RoleStore roles = new RoleStore(4);
        roles.add(new Role("1", "Role1"));
        roles.add(new Role("2", "Role2"));
        roles.add(new Role("3", "Role3"));
        roles.add(new Role("4", "Role4"));
        assertThat(roles.delete("4"), is(true));
    }

    @Test
    public void deleteElementFalseTest() {
        RoleStore roles = new RoleStore(4);
        roles.add(new Role("1", "Role1"));
        roles.add(new Role("2", "Role2"));
        roles.add(new Role("3", "Role3"));
        roles.add(new Role("4", "Role4"));
        assertThat(roles.delete("6"), is(false));
    }
}