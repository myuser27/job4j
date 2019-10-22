package ru.job4j.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static class Student {
        private int score;

        public Student(int score) {
            this.score = score;
        }
    }

    //public List<Student> collect(List<Student> students, Predicate<Student> predict) {
    public List<Student> collect(List<Student> students) {
        List<Student> class10a = students.stream().filter(student -> student.score < 50).collect(Collectors.toList());
        //class10a.forEach(System.out::println);
        for(Student s : class10a) {
            System.out.println(s.score);
        }
        return class10a;
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(40),
                new Student(45),
                new Student(49),
                new Student(55),
                new Student(65),
                new Student(90),
                new Student(95),
                new Student(100));
        List<Student> cl10a = new School().collect(students);
    }
}
