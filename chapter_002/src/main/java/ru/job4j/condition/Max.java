package ru.job4j.condition;

public class Max {
    public static int max(int first, int second) {
        return first > second ? first : second;
    }

    public static int max(int first, int second, int third) {
        int tmp = Max.max(first, second);
        return Max.max(tmp,third);
    }

    public static int max(int first, int second, int third, int fourth) {
        int tmp = Max.max(first, second, third);
        return Max.max(tmp, fourth);
    }
}
