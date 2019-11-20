package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleStackTest {
    @Test
    public void pushAndPollTest() {
        SimpleStack stack = new SimpleStack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertThat(stack.poll(), is("3"));
        assertThat(stack.poll(), is("2"));
        assertThat(stack.poll(), is("1"));
    }
}