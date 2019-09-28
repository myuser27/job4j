package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest
{
    public void whenMax1To4()
    {
        int result=SqMax.max(3,1,4,2);
        assertThat(result,is(4));
    }
}
