package ru.job4j.task;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoffeeTest {
    @Test
    public void whereChangeLess10() {
        Coffee coffee = new Coffee();
        int[] res = coffee.changes(32, 24);
        assertThat(res, is(new int[]{5, 2, 1}));
    }

    @Test
    public void whereChangeMore10() {
        Coffee coffee = new Coffee();
        int[] res = coffee.changes(32, 13);
        assertThat(res, is(new int[]{10, 5, 2, 2}));
    }

    @Test
    public void whereChangeMore30() {
        Coffee coffee = new Coffee();
        int[] res = coffee.changes(34, 1);
        assertThat(res, is(new int[]{10, 10, 10, 2, 1}));
    }
}
