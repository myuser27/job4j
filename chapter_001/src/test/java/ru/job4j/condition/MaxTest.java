package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest
{
    @Test
    public void whenMax1To2Then2()
    {
        int result=Max.max(1,2);
        assertThat(result,is(2));
    }

    @Test
    public void whenMaxFirstToSecondThenFirst()
    {
        int first=2;
        int second=1;
        int result=Max.max(first,second);
        assertThat(result,is(first));
    }

    @Test
    public void whenMaxFirstToSecondThenSecond()
    {
        int first=1;
        int second=2;
        int result=Max.max(first,second);
        assertThat(result,is(second));
    }

    @Test
    public void whenMaxFirstToSecondThenAny()
    {
        int first=1;
        int second=1;
        int result=Max.max(first,second);
        assertThat(result,is(first));
    }
}
