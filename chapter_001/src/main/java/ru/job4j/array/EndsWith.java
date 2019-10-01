package ru.job4j.array;

public class EndsWith {
    public static boolean endString(char[] word, char[] pref) {
        boolean result = true;
        for (int i = 0; i < pref.length; i++) {
            if (word[(word.length - 1) - i] != pref[(pref.length - 1) - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
