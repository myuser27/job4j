package ru.job4j.prof;

public class Dentist extends Doctor {
    private String type;

    public Dentist(String name, String sname, String edu, long date, float exp, String type) {
        super(name, sname, edu, date, exp);
        this.type = type;
    }

    boolean work(Doctor doc) {
        return true;
    }
}
