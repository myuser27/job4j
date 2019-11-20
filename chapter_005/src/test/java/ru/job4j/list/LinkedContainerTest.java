package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class LinkedContainerTest {

    @Test
    public void addAndGetTest() {
        LinkedContainer container = new LinkedContainer();
        container.add("1");
        container.add("2");
        container.add("3");
        assertThat(container.get(0), is("1"));
        assertThat(container.get(1), is("2"));
        assertThat(container.get(2), is("3"));
    }

    @Test
    public void iteratorTest() {
        LinkedContainer container = new LinkedContainer();
        container.add("1");
        container.add("2");
        container.add("3");
        Iterator iterator = container.iterator();
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("3"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorConcurrentModificationExceptionTest() {
        DinamicArray container = new DinamicArray(2);
        container.add("1");
        container.add("2");
        container.add("3");
        Iterator iterator = container.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("3"));
        container.add("4");
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNoSuchElementExceptionTest() {
        DinamicArray container = new DinamicArray(2);
        container.add("1");
        container.add("2");
        container.add("3");
        Iterator iterator = container.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("3"));
        iterator.next();
    }

    @Test
    public void whenTwoIteratorsTest() {
        LinkedContainer container = new LinkedContainer();
        container.add("1");
        container.add("2");
        container.add("3");
        container.add("4");
        Iterator iterator = container.iterator();
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("3"));
        Iterator newIterator = container.iterator();
        assertThat(newIterator.next(), is("1"));
        assertThat(newIterator.hasNext(), is(true));
        assertThat(newIterator.next(), is("2"));
        assertThat(newIterator.hasNext(), is(true));
        assertThat(newIterator.next(), is("3"));
        assertThat(newIterator.hasNext(), is(true));
        assertThat(newIterator.next(), is("4"));
        assertThat(newIterator.hasNext(), is(false));
    }
}