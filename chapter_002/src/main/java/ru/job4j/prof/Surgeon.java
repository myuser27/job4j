package ru.job4j.prof;

public class Surgeon extends Doctor {
    private int number;

    public Surgeon(String name, String sname, String edu, long date, float exp, int num) {
        super(name, sname, edu, date, exp);
        this.number = num;
    }

    int getNumber() {
        return this.number;
    }

    public boolean recover(Pacient pacient) {
        return pacient.getHeal();
    }
}
