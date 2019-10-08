package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println(" Can go.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Can go with " + count + " passengers");
    }

    @Override
    public int fill(int fuel) {
        int buck = 0;
        buck += fuel;
        return buck;
    }
}
