package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckPrimeNumberTest
{
    @Test
    public void when5()
    {
        CheckPrimeNumber prime=new CheckPrimeNumber();
        boolean result=prime.check(5);
        assertThat(result,is(true));
    }

    @Test
    public void when4()
    {
        CheckPrimeNumber prime=new CheckPrimeNumber();
        boolean result=prime.check(4);
        assertThat(result,is(false));
    }
}
