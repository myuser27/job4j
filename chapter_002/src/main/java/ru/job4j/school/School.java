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

        public int getScore() {
            return this.score;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            Student other = (Student) obj;
            if (this == obj || this.score == other.score) {
                result = true;
            }
            return result;
        }

        @Override
        public int hashCode() {
            return 17 * this.score;
        }
    }

    public List<Student> collect(List<Student> students, Predicate<Student> pred) {
        return students.stream().filter(pred).collect(Collectors.toList());
    }
}
