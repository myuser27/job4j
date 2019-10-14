package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int i = 0, j = 0;
        for (Integer el : list) {
            array[i][j] = el;
            j++;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }
}
