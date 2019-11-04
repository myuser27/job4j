package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    private Iterator<Integer> iterator = null;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            public Iterator<Integer> select() {
                Iterator<Integer> current = null;
                if (iterator != null && iterator.hasNext()) {
                    current = iterator;
                } else {
                    while (it.hasNext()) {
                        iterator = it.next();
                        if(iterator.hasNext()) {
                            current = iterator;
                            break;
                        }
                    }
                }
                return current;
            }

            @Override
            public boolean hasNext() {
                Iterator<Integer> iter = select();
                boolean result = false;
                if (iter != null) {
                    result = select().hasNext();
                }
                return result;
            }

            @Override
            public Integer next() {
                Iterator<Integer> iter = select();
                if (iter == null) {
                    throw new NoSuchElementException();
                }
                return iter.next();
            }
        };
    }
}
