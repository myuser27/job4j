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

    public int getIndexNextEven(int index) {
        int result = -1;
        if (this.numbers.length > 1) {
            index++;
            while (this.numbers.length > index) {
                if (isEven(index)) {
                    result = index;
                    break;
                }
                index++;
            }
        } else if (isEven(index)) {
            result = index;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.numbers.length > 1) {
            result = getIndexNextEven(this.index) > 0
                    || (this.index == this.numbers.length - 1 && isEven(this.index)) ? true : false;
        } else {
            result = this.index == 0 && isEven(this.index) ? true : false;
        }
        return result;
    }

    @Override
    public Object next() {
        int result = 0;
        if (!isEven(index)) {
            this.index = getIndexNextEven(this.index);
        }
        try {
            result = this.numbers[this.index];
            this.index++;
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new NoSuchElementException();
        }
        return result;
    }
}
