package ru.job4j.school;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {
    @Test
    public void whereClass10C() {
        List<School.Student> students = List.of(
                new School.Student(40),
                new School.Student(45),
                new School.Student(49),
                new School.Student(55),
                new School.Student(65),
                new School.Student(90),
                new School.Student(95),
                new School.Student(100));
        Predicate<School.Student> classC = p -> p.getScore() < 50;
        List<School.Student> expect = List.of(
                new School.Student(40),
                new School.Student(45),
                new School.Student(49));
        assertThat(new School().collect(students, classC), is(expect));
    }

    @Test
    public void whereClass10B() {
        List<School.Student> students = List.of(
                new School.Student(40),
                new School.Student(45),
                new School.Student(49),
                new School.Student(55),
                new School.Student(65),
                new School.Student(90),
                new School.Student(95),
                new School.Student(100));
        Predicate<School.Student> classB = p -> (p.getScore() < 70) && (p.getScore() >= 50);
        List<School.Student> expect = List.of(
                new School.Student(55),
                new School.Student(65));
        assertThat(new School().collect(students, classB), is(expect));
    }

    @Test
    public void whereClass10A() {
        List<School.Student> students = List.of(
                new School.Student(40),
                new School.Student(45),
                new School.Student(49),
                new School.Student(55),
                new School.Student(65),
                new School.Student(90),
                new School.Student(95),
                new School.Student(100));
        Predicate<School.Student> classA = p -> p.getScore() >= 70;
        List<School.Student> expect = List.of(
                new School.Student(90),
                new School.Student(95),
                new School.Student(100));
        assertThat(new School().collect(students, classA), is(expect));
    }
}
