package ru.job4j.set;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User o) {
        int result = 0;
        if (this.age > o.age) {
            result = 1;
        }
        if (this.age < o.age) {
            result = -1;
        }
        return result;
    }
}
