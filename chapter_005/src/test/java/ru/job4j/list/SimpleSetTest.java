package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleSetTest {
    @Test
    public void addAndIteratorTest() {
        SimpleSet set = new SimpleSet(3);
        set.add("1");
        set.add("2");
        set.add("3");
        Iterator it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void addOnlyUniqueTest() {
        SimpleSet set = new SimpleSet(6);
        set.add("1");
        set.add("2");
        set.add("2");
        set.add("1");
        set.add("3");
        set.add("3");
        Iterator it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void addNullTest() {
        SimpleSet set = new SimpleSet(3);
        set.add("1");
        set.add(null);
        set.add("2");
        set.add("1");
        Iterator it = set.iterator();
        assertThat(it.next(), is("1"));
        it.next();
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(false));
    }
}