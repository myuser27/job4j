package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {
    @Test
    public void square() {
        int p = 4, k = 1;
        double expacted = 1;
        double out = SqArea.square(p, k);
        Assert.assertEquals(expacted, out, 0.01);
    }
}
