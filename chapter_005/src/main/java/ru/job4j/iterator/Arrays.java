package ru.job4j.iterator;

import java.util.Iterator;

public class Arrays implements Iterator {
    private int[][] array;
    private int row = 0;
    private int col = 0;

    public Arrays(int[][] ar) {
        this.array = ar;
    }

    @Override
    public boolean hasNext() {
        return this.array[this.row].length > this.col;
    }

    @Override
    public Object next() {
        int result = this.array[this.row][this.col];
        if (this.array[this.row].length - 1 > this.col
                || this.row == this.array.length - 1) {
            this.col++;
        } else if (this.row < this.array.length - 1) {
            this.row++;
            this.col = 0;
        }
        return result;
    }
}
