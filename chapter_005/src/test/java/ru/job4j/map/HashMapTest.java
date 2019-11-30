package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class HashMapTest {
    @Test
    public void whenInsertTrueTest() {
        HashMap hm = new HashMap(2);
        assertThat(hm.insert("1", 1), is(true));
        assertThat(hm.insert("2", 2), is(true));
        assertThat(hm.insert("3", 3), is(true));
        assertThat(hm.insert("4", 4), is(true));
    }

    @Test
    public void whenInsertFalseTest() {
        HashMap hm = new HashMap();
        assertThat(hm.insert("1", 1), is(true));
        assertThat(hm.insert("2", 2), is(true));
        assertThat(hm.insert("2", 22), is(false));
    }

    @Test
    public void getTest() {
        HashMap hm = new HashMap();
        assertThat(hm.insert("1", 1), is(true));
        assertThat(hm.insert("2", 2), is(true));
        assertThat(hm.get("1"), is(1));
        assertThat(hm.get("2"), is(2));
    }

    @Test
    public void whenDeleteTrueTest() {
        HashMap hm = new HashMap();
        assertThat(hm.insert("1", 1), is(true));
        assertThat(hm.insert("2", 2), is(true));
        assertThat(hm.delete("2"), is(true));
    }

    @Test
    public void whenDeleteFalseTest() {
        HashMap hm = new HashMap();
        assertThat(hm.insert("1", 1), is(true));
        assertThat(hm.insert("2", 2), is(true));
        assertThat(hm.delete("3"), is(false));
    }

    @Test
    public void iteratorTest() {
        HashMap hm = new HashMap(2);
        hm.insert("1", 1);
        hm.insert("2", 2);
        hm.insert("3", 3);
        hm.insert("4", 4);
        Iterator it = hm.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }
}