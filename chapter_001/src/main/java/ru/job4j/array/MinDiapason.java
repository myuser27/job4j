package ru.job4j.array;

public class MinDiapason {
    public static int findMin(int[] arr, int start, int finish) {
        int min = arr[start];
        for (int i = start + 1; i <= finish; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
