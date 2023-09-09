package streams.challenges;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task3 {

    public String findTopStudent(List<Student> students) {
        return students.stream()
                //  .max( (s1, s2) -> (int) (s1.getGrade() - s2.getGrade()))
                .max(Comparator.comparing(Student::getGrade))
                .map(Student::getName)
                .orElse("No student found");
    }

    @Test
    public void testFindTopStudent() {
        Student s1 = new Student("John", 18, 85);
        Student s2 = new Student("Mary", 19, 90);
        Student s3 = new Student("Mike", 20, 80);
        Student s4 = new Student("David", 18, 95);
        List<Student> students = Arrays.asList(s1, s2, s3, s4);

        String expected = "David";
        String actual = findTopStudent(students);

        assertEquals(expected, actual);
    }

    static class Student {
        private String name;
        private int age;
        private double grade;

        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }
    }
}
