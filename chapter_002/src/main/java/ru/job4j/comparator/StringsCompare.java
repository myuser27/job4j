package ru.job4j.comparator;

import java.util.Comparator;

public class StringsCompare implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        int result = 0;
        int minlen = first.length() <= second.length()
                ? first.length() : second.length();
        for (int i = 0; i < minlen; i++) {
            result = Integer.compare((int) first.charAt(i), (int) second.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && second.length() != first.length()) {
            result = second.length() > first.length() ? -1 : 1;
        }
        return result;
    }
}
