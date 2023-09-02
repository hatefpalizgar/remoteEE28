package streams.example.no1;

import streams.example.no2.Example02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example01 {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 40);
        Employee jack = new Employee("Jack Hill", 39);
        Employee snow = new Employee("Snow White", 35);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = Arrays.asList(hr, accounting);

        // use Streams API to print the employees names in each department
        departments.stream()
                .map(department -> department.getEmployees())// convert each department to its list of employees --> Stream<List<Employee>>
                .forEach(   // for each list of employees do below
                        list -> list.forEach(e -> System.out.println(e.getName()))
                );

        // second solution:
        /**
         * For a better example of FlatMap()
         * @see FlatMapExample1
         * */
        departments.stream()
                .flatMap(department -> department.getEmployees().stream()) // Stream<Employee>
                .forEach(e -> System.out.println(e.getName()));


        // use Streams API to create a Map<Integer, List<Employee>> that groups employees by their age e.g. [30 --> {e1,e2,e3}]
        Map<Integer, List<Employee> > groupedByAge = departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.groupingBy( e -> e.getAge()));


        // TODO: what is the goal of below code?
        // TODO: what is ternary if in Java?
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2) -> e1.getAge() > e2.getAge() ? e1: e2)
                .ifPresent(e -> System.out.println(e.getName()));


        /**
         * @see Example02
         * */

    }
}
