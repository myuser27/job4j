package ru.job4j.generic;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {

    @Test
    public void addAndGetTest() {
        SimpleArray sa = new SimpleArray(2);
        sa.add("test1");
        sa.add("test2");
        assertThat(sa.get(0), is("test1"));
        assertThat(sa.get(1), is("test2"));
    }

    @Test
    public void setTest() {
        SimpleArray sa = new SimpleArray(2);
        sa.add("test1");
        sa.add("test2");
        sa.set(1, "TEST2");
        assertThat(sa.get(1), is("TEST2"));
    }

    @Test
    public void removeTest() {
        SimpleArray sa = new SimpleArray(4);
        sa.add("test1");
        sa.add("test2");
        sa.add("test3");
        sa.add("test4");
        sa.remove(1);
        assertThat(sa.get(0), is("test1"));
        assertThat(sa.get(1), is("test3"));
        assertThat(sa.get(3), is("test4"));
    }

    @Test
    public void iteratorTest() {
        SimpleArray sa = new SimpleArray(4);
        sa.add("test1");
        sa.add("test2");
        sa.add("test3");
        sa.add("test4");
        assertThat(sa.iterator().hasNext(), is(true));
        assertThat(sa.iterator().next(), is("test1"));
        assertThat(sa.iterator().hasNext(), is(true));
        assertThat(sa.iterator().next(), is("test2"));
        assertThat(sa.iterator().hasNext(), is(true));
        assertThat(sa.iterator().next(), is("test3"));
        assertThat(sa.iterator().hasNext(), is(true));
        assertThat(sa.iterator().next(), is("test4"));
        assertThat(sa.iterator().hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorExceptionTest() {
        SimpleArray sa = new SimpleArray(4);
        sa.add("test1");
        sa.add("test2");
        sa.add("test3");
        sa.add("test4");
        assertThat(sa.iterator().hasNext(), is(true));
        assertThat(sa.iterator().next(), is("test1"));
        assertThat(sa.iterator().hasNext(), is(true));
        assertThat(sa.iterator().next(), is("test2"));
        assertThat(sa.iterator().hasNext(), is(true));
        assertThat(sa.iterator().next(), is("test3"));
        assertThat(sa.iterator().hasNext(), is(true));
        assertThat(sa.iterator().next(), is("test4"));
        assertThat(sa.iterator().hasNext(), is(false));
        sa.iterator().next();
    }
}