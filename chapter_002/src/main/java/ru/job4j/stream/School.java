package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    public static class Student implements Comparable<Student> {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            int result = 0;
            result = this.score < o.score ? 1 : -1;
            return result;
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

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(Comparator.nullsLast(Student::compareTo))
                .flatMap(Stream::ofNullable).takeWhile(s -> s.score > bound)
                .collect(Collectors.toList());
    }
}
