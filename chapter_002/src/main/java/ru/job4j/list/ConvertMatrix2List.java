package ru.job4j.list;

import java.util.List;
import java.util.ArrayList;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>(array.length);
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                list.add(row[i]);
            }
        }
        return list;
    }
}