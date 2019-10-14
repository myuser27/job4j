package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] el : list) {
            for (int i : el) {
                result.add(i);
            }
        }
        return result;
    }
}
