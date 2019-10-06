package ru.job4j.prof;

public class Pacient {
    private String name;
    private String surname;
    private long birthday;
    private String diagnose;
    private boolean heal;

    public Pacient(String name, String sname, long date, String diag) {
        this.name = name;
        this.surname = sname;
        this.birthday = date;
        this.diagnose = diag;
        this.heal = false;
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public long getBirthday() {
        return this.birthday;
    }
    public String getDiagnose() {
        return this.diagnose;
    }
    public boolean getHeal() {
        return this.heal;
    }
    public void setRecover() {

    }
}
