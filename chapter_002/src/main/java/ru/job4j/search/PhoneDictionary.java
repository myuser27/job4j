package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        var result = new ArrayList<Person>();
        for (var p : persons) {
            if (p.getName().contains(key) || p.getSurname().contains(key)
                    || p.getAddress().contains(key) || p.getPhone().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}