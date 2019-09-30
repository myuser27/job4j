package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest
{
    @Test
    public void whenDataMono()
    {
        Check check=new Check();
        boolean[] input=new boolean[] {true, true, true};
        boolean result=check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMono()
    {
        Check check=new Check();
        boolean[] input=new boolean[] {true, false, true};
        boolean result=check.mono(input);
        assertThat(result, is(false));
    }
}
