package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void square() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        Point c = new Point(2, 2);
        Triangle triangle = new Triangle(a, b, c);
        double s = triangle.area();
        double expected = 1;
        Assert.assertEquals(expected, s, 0.01);
    }
}
