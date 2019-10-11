package ru.job4j.tracker;

public class TrackerSingle1 extends BaseTrackerSingle {
    public enum TrackerSingle {
        INSTANCE;

        public Item add(Item model) {
            return model;
        }
    }
}
