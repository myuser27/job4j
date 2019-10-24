package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public List<Integer> convertList(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(m -> Arrays.stream(m)).collect(Collectors.toList());
    }
}
