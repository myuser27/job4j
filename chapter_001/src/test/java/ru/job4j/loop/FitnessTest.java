package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FitnessTest {
    @Test
    public void whenIvanGreatNik() {
        Fitness fit = new Fitness();
        int mon = fit.calc(95, 90);
        assertThat(mon, is(0));
    }

    @Test
    public void whenIvanLessByOneNik() {
        Fitness fit = new Fitness();
        int mon = fit.calc(90, 95);
        assertThat(mon, is(1));
    }

    @Test
    public void whenIvanLessByFewNik() {
        Fitness fit = new Fitness();
        int mon = fit.calc(50, 95);
        assertThat(mon, is(2));
    }
}
