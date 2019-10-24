package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {
    @Test
    public void whereStudentsList() {
        List<School.Student> students = new ArrayList<School.Student>();
        students.add(new School.Student("name1", 72));
        students.add(null);
        students.add(new School.Student("name5", 82));
        students.add(new School.Student("name3", 42));
        students.add(new School.Student("name2", 92));
        List<School.Student> expect = List.of(
                new School.Student("name2", 92),
                new School.Student("name5", 82),
                new School.Student("name1", 72));
        assertThat(new School().levelOf(students, 70), is(expect));
    }
}
