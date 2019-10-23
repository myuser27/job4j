package ru.job4j.school;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {
    @Test
    public void whereClass10C() {
        List<School.Student> students = List.of(
                new School.Student("name1",40),
                new School.Student("name2",45),
                new School.Student("name3",49),
                new School.Student("name4",55),
                new School.Student("name5",65),
                new School.Student("name6",90),
                new School.Student("name7",95),
                new School.Student("name8",100));
        Predicate<School.Student> classC = p -> p.getScore() < 50;
        List<School.Student> expect = List.of(
                new School.Student("name1",40),
                new School.Student("name2",45),
                new School.Student("name3",49));
        assertThat(new School().collect(students, classC), is(expect));
    }

    @Test
    public void whereClass10B() {
        List<School.Student> students = List.of(
                new School.Student("name1",40),
                new School.Student("name2",45),
                new School.Student("name3",49),
                new School.Student("name4",55),
                new School.Student("name5",65),
                new School.Student("name6",90),
                new School.Student("name7",95),
                new School.Student("name8",100));
        Predicate<School.Student> classB = p -> (p.getScore() < 70) && (p.getScore() >= 50);
        List<School.Student> expect = List.of(
                new School.Student("name4",55),
                new School.Student("name5",65));
        assertThat(new School().collect(students, classB), is(expect));
    }

    @Test
    public void whereClass10A() {
        List<School.Student> students = List.of(
                new School.Student("name1",40),
                new School.Student("name2",45),
                new School.Student("name3",49),
                new School.Student("name4",55),
                new School.Student("name5",65),
                new School.Student("name6",90),
                new School.Student("name7",95),
                new School.Student("name8",100));
        Predicate<School.Student> classA = p -> p.getScore() >= 70;
        List<School.Student> expect = List.of(
                new School.Student("name6",90),
                new School.Student("name7",95),
                new School.Student("name8",100));
        assertThat(new School().collect(students, classA), is(expect));
    }

    @Test
    public void whereStudentsListToMap() {
        List<School.Student> students = List.of(
                new School.Student("name1",40),
                new School.Student("name2",45),
                new School.Student("name3",49));
        Predicate<School.Student> classC = p -> p.getScore() != 0;
        Map<String, School.Student> expect = Map.of(
                "name1", new School.Student("name1",40),
                "name2", new School.Student("name2",45),
                "name3", new School.Student("name3",49));
        assertThat(new School().convert(students), is(expect));
    }
}
