package ru.job4j.loop;

public class Mortgage {
    public int calc(int amount, int salary, double percent) {
        int year = 1;
        double rest = amount + amount * percent / 100;
        rest -= salary;
        while (rest > 0) {
            rest += rest * percent / 100;
            rest -= salary;
            year++;
        }
        return year;
    }
}
