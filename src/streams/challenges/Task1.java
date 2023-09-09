package streams.challenges;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task1 {

    public List<String> filterAndMap(List<Employee> employees) {
        List<String> result = employees.stream()
                .filter(e -> e.getSalary() > 5000 && e.getDepartment().equalsIgnoreCase("sales"))
                .map(e -> e.getName())
                .collect(Collectors.toList());

        return result;
    }

    @Test
    public void testFilterAndMap() {
        Employee e1 = new Employee("John", 7000, "Sales");
        Employee e2 = new Employee("Mary", 5500, "Sales");
        Employee e3 = new Employee("Mike", 4500, "Marketing");
        Employee e4 = new Employee("David", 6000, "Sales");
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4);

        List<String> expected = Arrays.asList("John", "Mary", "David");
        List<String> actual = filterAndMap(employees);

        assertEquals(expected, actual);
    }



    static class Employee {
        private String name;
        private int salary;
        private String department;

        public Employee(String name, int salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }
    }
}

