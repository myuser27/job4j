package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PrimeNumberTest
{
    @Test
    public void when5()
    {
        PrimeNumber prime=new PrimeNumber();
        int result=prime.calc(5);
        assertThat(result,is(3));
    }

    @Test
    public void when11()
    {
        PrimeNumber prime=new PrimeNumber();
        int result=prime.calc(11);
        assertThat(result,is(5));
    }

    @Test
    public void when2()
    {
        PrimeNumber prime=new PrimeNumber();
        int result=prime.calc(2);
        assertThat(result,is(1));
    }
}
