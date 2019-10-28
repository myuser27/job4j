package ru.job4j.task;

import java.util.Arrays;

public class StreamAPI {
    private final int[] array = {1, 2, 3, 4, 5, 6, 7, 8};

    public int[] even() {
        return Arrays.stream(this.array).filter(x -> x % 2 == 0).toArray();
    }

    public int[] square() {
        return Arrays.stream(this.array).map(x -> x * x).toArray();
    }

    public int sum() {
        return Arrays.stream(this.array).sum();
    }
}
