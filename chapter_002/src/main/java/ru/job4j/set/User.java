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
        if (this.age != o.age) {
            result = this.age > o.age ? 1 : -1;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        User other = (User) obj;
        if (this == obj || (this.age == other.age
                && this.name.equals(other.name))) {
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return 17 * this.age + this.name.hashCode();
    }
}
