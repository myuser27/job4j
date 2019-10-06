package ru.job4j.prof;

public class Doctor extends Profession {
    private float experience;

    public Doctor(String name, String sname, String edu, long date, float exp) {
        super(name, sname, edu, date);
        this.experience = exp;
    }
}
