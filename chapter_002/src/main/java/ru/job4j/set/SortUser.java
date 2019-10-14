package ru.job4j.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<User>(list);
        return users;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("Ivan", 30));
        users.add(new User("Semen", 22));
        users.add(new User("Alex", 44));
        users.add(new User("Fedor", 28));
        Set<User> userset = new SortUser().sort(users);
        for (User u : userset) {
            System.out.println("Name: " + u.getName() + ", age: " + u.getAge());
        }
    }
}
