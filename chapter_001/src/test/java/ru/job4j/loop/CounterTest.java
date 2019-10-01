package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSum1To10() {
        int check = Counter.add(1, 10);
        assertThat(check, is(30));
    }
}
