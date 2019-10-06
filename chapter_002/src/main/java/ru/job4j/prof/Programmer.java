package ru.job4j.prof;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String sname, String edu, long date,
                      String type, String lang) {
        super(name, sname, edu, date, type);
        this.language = lang;
    }

    public boolean can() {
        return true;
    }
}
