package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void dist3D() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 2, 0);
        double dist = a.distance3d(b);
        assertEquals(dist, 2.0, 0.01);
    }
}
