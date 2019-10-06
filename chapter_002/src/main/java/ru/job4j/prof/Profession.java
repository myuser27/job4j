package ru.job4j.prof;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private long birthday;

    public Profession(String name, String sname, String edu, long date) {
        this.name = name;
        this.surname = sname;
        this.education = edu;
        this.birthday = date;
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getEducation() {
        return this.education;
    }
    public long getBirthday() {
        return this.birthday;
    }
}
