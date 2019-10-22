package ru.job4j.task;

import java.util.*;

public class DepartmentSortSet {
    private final String[] departments = {"K1\\SK1", "K1\\SK2",
            "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
            "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
    private final String[] names = {"K1", "K1\\SK1", "K1\\SK2", "K2", "K2\\SK1"};

    public Set<String> fillMissingTreeSet() {
        Set<String> depSet = new TreeSet<>();
        Collections.addAll(depSet, this.departments);
        for (int i = 0; i < this.names.length; i++) {
            if (!depSet.contains(this.names[i])) {
                depSet.add(this.names[i]);
            }
        }
        return depSet;
    }

    public Set<String> fillMissingTreeSet(String[] array) {
        Set<String> depSet = new TreeSet<>();
        Collections.addAll(depSet, array);
        for (int i = 0; i < this.names.length; i++) {
            if (!depSet.contains(this.names[i])) {
                depSet.add(this.names[i]);
            }
        }
        return depSet;
    }

    public Set<String> sortReversTreeSet(String[] array) {
        Set<String> depSet = new TreeSet<>(new Comparator<String>() {
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
        Collections.addAll(depSet, array);
        return depSet;
    }

    public Set<String> abs(String[] array) {
        Set<String> depSet = new TreeSet<>(new Comparator<String>() {
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
        Collections.addAll(depSet, array);
        return depSet;
    }

    public List<String> fillMissingArrayList() {
        List<String> depList = new ArrayList<>();
        Collections.addAll(depList, this.departments);
        for (int i = 0; i < this.names.length; i++) {
            if (!depList.contains(this.names[i])) {
                depList.add(this.names[i]);
            }
        }
        depList.sort(null);
        return depList;
    }

    public List<String> sortReversArrayList(String[] array) {
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
        return sortedList;
    }

    public static void main(String[] args) {
        String[] dep = {"K1\\SK1", "K1\\SK2",
                "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        DepartmentSortSet dss = new DepartmentSortSet();
        Set<String> resultSet = dss.fillMissingTreeSet(dep);
        System.out.println(resultSet);
        System.out.println();
        String[] array = new String[resultSet.size()];
        System.out.println(dss.sortReversTreeSet(resultSet.toArray(array)));
        List<String> resultList = dss.fillMissingArrayList();
        System.out.println();
        System.out.println(resultList);
        System.out.println();
        System.out.println(dss.sortReversArrayList(resultList.toArray(new String[0])));
    }
}
