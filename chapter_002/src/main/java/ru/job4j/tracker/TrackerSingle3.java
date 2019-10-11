package ru.job4j.tracker;

public class TrackerSingle3 extends BaseTrackerSingle {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();

    private TrackerSingle3() {
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }
}
