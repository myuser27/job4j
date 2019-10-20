package ru.job4j.task;

import java.util.*;

public class DepartmentsSort {
    private String[] array = {"K1\\SK1", "K1\\SK2",
            "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
            "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};

    private String[][] depName = {{"K1\\", "K2\\"}, {"SK1\\", "SK2\\"}};

    public String[] sort() {
        List<String> departments = new ArrayList<String>();
        Collections.addAll(departments, this.array);
        departments.sort(null);
        ListIterator<String> listIt = departments.listIterator();
        String tmp;
        while (listIt.hasNext()) {
            tmp = listIt.next();
            for (int i = 0; i < depName.length; i++) {
                for (int j = 0; j < depName[i].length; j++) {
                    if (i == 0) {
                        if (tmp.contains(depName[i][j])
                                && !departments.contains(depName[i][j].substring(0,
                                depName[i][j].length() - 1))) {
                            listIt.previous();
                            listIt.add(depName[i][j].substring(0, depName[i][j].length() - 1));
                            listIt.next();
                            break;
                        }
                    } else {
                        if (tmp.contains(depName[i - 1][i - 1] + depName[i][j])
                                && !departments.contains(depName[i - 1][i - 1]
                                + depName[i][j].substring(0, depName[i][j].length() - 1))) {
                            listIt.previous();
                            listIt.add(depName[i - 1][i - 1]
                                    + depName[i][j].substring(0, depName[i][j].length() - 1));
                            listIt.next();
                            break;
                        }
                        if (tmp.contains(depName[i - 1][i] + depName[i][j])
                                && !departments.contains(depName[i - 1][i]
                                + depName[i][j].substring(0, depName[i][j].length() - 1))) {
                            listIt.previous();
                            listIt.add(depName[i - 1][i]
                                    + depName[i][j].substring(0, depName[i][j].length() - 1));
                            listIt.next();
                            break;
                        }
                    }
                }
            }
        }
        return departments.toArray(new String[0]);
    }

    public String[] sortRevers(String[] array) {
        List<String> sortedList = new ArrayList<String>();
        List<String> part = new ArrayList<String>();
        for (int i = array.length - 1; i > -1; i--) {
            part.add(array[i]);
            if (array[i].length() == 2) {
                part.sort(new Comparator<String>() {
                    @Override
                    public int compare(String str1, String str2) {
                        int result = 0;
                        if (str1.length() != str2.length()) {
                            result = str1.length() > str2.length() ? 1 : -1;
                        } else {
                            result = str2.compareTo(str1);
                        }
                        return result;
                    }
                });
                sortedList.addAll(part);
                part.clear();
            }
        }
        return sortedList.toArray(new String[0]);
    }
}