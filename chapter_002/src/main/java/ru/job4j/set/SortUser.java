package ru.job4j.set;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<User>(list);
        return users;
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                int result = 0;
                if (u1.getName().length() != u2.getName().length()) {
                    result = u1.getName().length() > u2.getName().length() ? 1 : -1;
                }
                return result;
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                int result = u1.getName().compareTo(u2.getName());
                if (result == 0) {
                    if (u1.getAge() != u2.getAge()) {
                        result = u1.getAge() > u2.getAge() ? 1 : -1;
                    }
                }
                return result;
            }
        });
        return list;
    }

    public static void main(String[] args) {
        SortUser su = new SortUser();
        List<User> users = new ArrayList<User>();
        users.add(new User("Ivan", 30));
        users.add(new User("Aleksei", 22));
        users.add(new User("El", 44));
        users.add(new User("Vladimir", 28));
        users.add(new User("El", 20));
        Set<User> userset = su.sort(users);
        for (User u : userset) {
            System.out.println("Name: " + u.getName() + ", age: " + u.getAge());
        }
        List<User> susers = su.sortNameLength(users);
        System.out.println();
        for (User u : susers) {
            System.out.println("Name: " + u.getName() + ", age: " + u.getAge());
        }
        susers = su.sortByAllFields(users);
        System.out.println();
        for (User u : susers) {
            System.out.println("Name: " + u.getName() + ", age: " + u.getAge());
        }
    }
}
