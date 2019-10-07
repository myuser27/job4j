package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanod Ivan");
        student.setGroup("group1");
        student.setDate(new Date());

        System.out.println(student.getName() + " " + student.getGroup() + " " + student.getDate());
    }
}
