package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
    @Test
    public void whenBound3() {
        Square square = new Square();
        int[] rst = square.calculate(3);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound4() {
        Square square = new Square();
        int[] rst = square.calculate(4);
        int[] expect = new int[]{1, 4, 9, 16};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound5() {
        Square square = new Square();
        int[] rst = square.calculate(5);
        int[] expect = new int[]{1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }
}
