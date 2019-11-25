package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public boolean equals(Object obj) {
        boolean result = false;
        User other = (User) obj;
        if (this == other
                || (this.name.equals(other.name)
                && this.children == other.children
                && this.birthday.equals(other.birthday))) {
            result = true;
        }
        return result;
    }

    public int hashCode() {
        return 17 * this.name.hashCode() + this.children + this.birthday.hashCode();
    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", 10,
                new GregorianCalendar(2009, Calendar.JANUARY, 12));
        User user2 = new User("Ivan", 10,
                new GregorianCalendar(2009, Calendar.JANUARY, 12));
        Map<User, String> map = new HashMap<User, String>();
        map.put(user1, "first user");
        map.put(user2, "second user");
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
    }
}
