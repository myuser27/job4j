package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class UserConvert {
    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> result = new HashMap<Integer, User>();
        Integer key;
        for (User u : list) {
            key = u.getId();
            result.put(key, u);
        }
        return result;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Ivan1", "City1"));
        users.add(new User(2, "Ivan2", "City2"));
        users.add(new User(3, "Ivan3", "City3"));
        users.add(new User(4, "Ivan4", "City4"));
        Map<Integer, User> res = new UserConvert().process(users);
        for (Map.Entry<Integer, User> el : res.entrySet()) {
            System.out.println("Key: " + el.getKey() + ", User: "
                    + el.getValue().getName()
                    + ", City: " + el.getValue().getCity());
        }
    }
}
