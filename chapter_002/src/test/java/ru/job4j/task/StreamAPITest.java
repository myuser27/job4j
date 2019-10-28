package ru.job4j.task;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StreamAPITest {
    @Test
    public void whereEvenArray() {
        int[] expected = {2, 4, 6, 8};
        assertThat(new StreamAPI().even(), is(expected));
    }

    @Test
    public void whereSquareArray() {
        int[] expected = {1, 4, 9, 16, 25, 36, 49, 64};
        assertThat(new StreamAPI().square(), is(expected));
    }

    @Test
    public void whereSumArray() {
        int expected = 36;
        assertThat(new StreamAPI().sum(), is(expected));
    }
}
