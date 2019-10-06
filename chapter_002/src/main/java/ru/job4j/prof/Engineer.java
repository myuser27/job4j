package ru.job4j.prof;

public class Engineer extends Profession {
    private String type;

    public Engineer(String name, String sname, String edu, long date, String type) {
        super(name, sname, edu, date);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
