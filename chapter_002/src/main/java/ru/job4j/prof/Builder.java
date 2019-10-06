package ru.job4j.prof;

public class Builder extends Engineer {
    private String qualification;

    public Builder(String name, String sname, String edu, long date,
                   String type, String qual) {
        super(name, sname, edu, date, type);
        this.qualification = qual;
    }

    public int work(House house) {
        int year = 0;

        return year;
    }
}
