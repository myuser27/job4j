package ru.job4j.task;

import java.util.Arrays;

public class Coffee {
    final int[] monets = {1, 2, 5, 10};

    int[] changes(int value, int price) {
        int[] tmp = {0, 0, 0, 0};
        int del = value - price;
        int count = 0;
        for (int i = monets.length - 1; i >= 0; i--) {
            if (del % monets[i] == 0) {
                tmp[i] += del / monets[i];
                break;
            } else {
                tmp[i] += Math.floorDiv(del, monets[i]);
                del = del % monets[i];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            count += tmp[i];
        }
        int[] result = new int[count];
        for (int i = tmp.length - 1, j = 0; i >= 0; i--) {
            if (tmp[i] != 0) {
                for (int i2 = 0; i2 < tmp[i]; i2++) {
                    result[j] = monets[i];
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        int[] res = coffee.changes(32, 3);
        System.out.println(Arrays.toString(res));
    }
}
