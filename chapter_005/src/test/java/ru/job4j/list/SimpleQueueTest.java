package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleQueueTest {

    @Test
    public void pushAndPollTest() {
        SimpleQueue queue = new SimpleQueue();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        assertThat(queue.poll(), is("1"));
        assertThat(queue.poll(), is("2"));
        assertThat(queue.poll(), is("3"));
    }
}