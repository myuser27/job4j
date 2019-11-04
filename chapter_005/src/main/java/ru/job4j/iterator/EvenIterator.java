package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private int[] numbers;
    private int index = 0;

    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }

    public boolean isEven(int index) {
        return this.numbers[index] % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = this.index; i < this.numbers.length; i++) {
            if (isEven(i)) {
                result = true;
                this.index = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return this.numbers[index++];
    }
}
