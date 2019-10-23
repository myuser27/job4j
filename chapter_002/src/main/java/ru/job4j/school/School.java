package ru.job4j.school;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return this.score;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            Student other = (Student) obj;
            if (this == obj || (this.score == other.score
                    && this.name.equals(other.name))) {
                result = true;
            }
            return result;
        }

        @Override
        public int hashCode() {
            return 17 * this.score + this.name.hashCode();
        }
    }

    public List<Student> collect(List<Student> students, Predicate<Student> pred) {
        return students.stream().filter(pred).collect(Collectors.toList());
    }

    public Map<String, Student> convert(List<Student> students) {
        return students.stream().distinct()
                .collect(Collectors.toMap(s -> s.name, s -> s));
    }
}
