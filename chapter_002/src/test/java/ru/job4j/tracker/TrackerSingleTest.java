package ru.job4j.tracker;

import org.junit.Test;

public class TrackerSingleTest {
    @Test
    public void whereSingleton1() {
        TrackerSingle1.TrackerSingle tracker1 = TrackerSingle1.TrackerSingle.INSTANCE;
        TrackerSingle1.TrackerSingle tracker2 = TrackerSingle1.TrackerSingle.INSTANCE;
        if(tracker1 == tracker2) {
            System.out.println("Singl object");
        }
    }

    @Test
    public void whereSingleton2() {
        TrackerSingle2 tracker1 = TrackerSingle2.getInstance();
        TrackerSingle2 tracker2 = TrackerSingle2.getInstance();
        if(tracker1 == tracker2) {
            System.out.println("Singl object");
        }
    }

    @Test
    public void whereSingleton3() {
        TrackerSingle3 tracker1 = TrackerSingle3.getInstance();
        TrackerSingle3 tracker2 = TrackerSingle3.getInstance();
        if(tracker1 == tracker2) {
            System.out.println("Singl object");
        }
    }

    @Test
    public void whereSingleton4() {
        TrackerSingle4 tracker1 = TrackerSingle4.getInstance();
        TrackerSingle4 tracker2 = TrackerSingle4.getInstance();
        if(tracker1 == tracker2) {
            System.out.println("Singl object");
        }
    }
}
