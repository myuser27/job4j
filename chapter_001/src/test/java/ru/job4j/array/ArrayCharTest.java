package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayCharTest {
    @Test
    public void whenStartStringTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e'};
        boolean result = ArrayChar.startString(word, pref);
        assertThat(result, is(true));
    }

    @Test
    public void whenStartStringFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'i'};
        boolean result = ArrayChar.startString(word, pref);
        assertThat(result, is(false));
    }
}
