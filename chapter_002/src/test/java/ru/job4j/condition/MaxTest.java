package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxTest {
    @Test
    public void whenMax1To2Then1() {
        int result = Max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax1To3Then2() {
        int result = Max.max(2, 3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax1To4Then3() {
        int result = Max.max(2, 1, 3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax1To4Then4() {
        int result = Max.max(1, 2, 2, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenMax1To4Any() {
        int result = Max.max(2, 2, 2, 2);
        assertThat(result, is(2));
    }
}
