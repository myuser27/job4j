package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];

        if (first.length == 0) {
            result = Arrays.copyOf(second, second.length);
            return result;
        }

        int i1 = 0, i2 = 0, i3 = 0;
        boolean end = false;
        while (i3 < result.length - 1) {
            if (first[i1] <= second[i2] && !end) {
                result[i3] = first[i1];
                i1++;
                if (i1 == first.length) {
                    i1--;
                    end = true;
                }
            } else {
                result[i3] = second[i2];
                if (i2 < second.length) {
                    i2++;
                }
            }
            i3++;
            if (i1 == first.length - 1 && i2 == second.length - 1) {
                if (first[i1] > second[i2]) {
                    result[i3] = first[i1];
                } else {
                    result[i3] = second[i2];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] arr = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 2, 4, 5}
        );
        System.out.println(Arrays.toString(arr));
    }
}
