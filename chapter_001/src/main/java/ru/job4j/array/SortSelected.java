package ru.job4j.array;

public class SortSelected {
    public static int[] sort(int[] data) {
        MinDiapason findmin = new MinDiapason();
        FindLoop findindex = new FindLoop();
        int end = data.length - 1;
        int min = findmin.findMin(data, 0, end);
        int index = findindex.indexOf(data, min, 0, end);
        int tmp = data[0];
        data[0] = data[index];
        data[index] = tmp;
        for (int i = 1; i < data.length; i++) {
            min = findmin.findMin(data, i, end);
            index = findindex.indexOf(data, min, i, end);
            tmp = data[i];
            data[i] = data[index];
            data[index] = tmp;
        }
        return data;
    }
}
