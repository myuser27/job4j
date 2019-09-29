package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest
{
    @Test
    public void whenFactorialToFive()
    {
        int check=Factorial.calc(5);
        assertThat(check,is(120));
    }
}
