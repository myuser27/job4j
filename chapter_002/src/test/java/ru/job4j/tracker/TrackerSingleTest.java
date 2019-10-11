package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TrackerSingleTest {
    @Test
    public void whereSingleton1() {
        TrackerSingle1.TrackerSingle tracker1 = TrackerSingle1.TrackerSingle.INSTANCE;
        TrackerSingle1.TrackerSingle tracker2 = TrackerSingle1.TrackerSingle.INSTANCE;
        assertTrue(tracker1 == tracker2);
    }

    @Test
    public void whereSingleton2() {
        TrackerSingle2 tracker1 = TrackerSingle2.getInstance();
        TrackerSingle2 tracker2 = TrackerSingle2.getInstance();
        assertTrue(tracker1 == tracker2);
    }

    @Test
    public void whereSingleton3() {
        TrackerSingle3 tracker1 = TrackerSingle3.getInstance();
        TrackerSingle3 tracker2 = TrackerSingle3.getInstance();
        assertTrue(tracker1 == tracker2);
    }

    @Test
    public void whereSingleton4() {
        TrackerSingle4 tracker1 = TrackerSingle4.getInstance();
        TrackerSingle4 tracker2 = TrackerSingle4.getInstance();
        assertTrue(tracker1 == tracker2);
    }
}
