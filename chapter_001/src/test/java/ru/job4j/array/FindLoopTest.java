package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindLoopTest
{
    @Test
    public void whenArrayHas5()
    {
        FindLoop find=new FindLoop();
        int[] arr=new int[] {1,2,3,4,5,6,7,8};
        int index=find.indexOf(arr,5);
        assertThat(index,is(4));
    }

    @Test
    public void whenArrayNothing()
    {
        FindLoop find=new FindLoop();
        int[] arr=new int[] {1,2,3,4,5,6,7};
        int index=find.indexOf(arr,9);
        assertThat(index,is(-1));
    }
}
