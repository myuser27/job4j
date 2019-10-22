package ru.job4j.functions;

import org.junit.Test;

import java.util.List;
import java.util.Arrays;

import org.junit.Assert;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalcTest {
    @Test
    public void whenLinearFunction() {
        Calc function = new Calc();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expect = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expect));
    }

    @Test
    public void whenQuadraticFunction() {
        Calc function = new Calc();
        List<Double> result = function.diapason(1, 5, x -> x * x);
        List<Double> expect = Arrays.asList(1D, 4D, 9D, 16D);
        assertThat(result, is(expect));
    }

    @Test
    public void whenLogFunction() {
        Calc function = new Calc();
        List<Double> result = function.diapason(10, 13, x -> Math.log10(x));
        List<Double> expect = Arrays.asList(1D, 1.04D, 1.08D);
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(result.get(i), expect.get(i), 0.01);
        }
    }
}
