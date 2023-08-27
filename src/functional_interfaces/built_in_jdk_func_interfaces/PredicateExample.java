package functional_interfaces.built_in_jdk_func_interfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Checker<String> checker = (message) -> message.contains("Java");

        boolean isAJavaDeveloper = checker.check("John is a Java developer");

        System.out.println(isAJavaDeveloper); // true


        Checker<Teacher> lab = (teacher) -> {
            return teacher.getAge() > 30;
        };

        Teacher teacher = new Teacher("John", 25);

        boolean result = lab.check(teacher);
        System.out.println(result); // false

        // Predicate is the name of Java built-in functional interface that takes param(s),
        // and returns a boolean result

        // The abstract method in any Predicate is called 'test(...)'

        Predicate<Teacher> predicate = t -> t.getName().contains("H");

        System.out.println(predicate.test(teacher));  // false
        System.out.println(predicate.test(new Teacher("Hatef", 35))); // true


        /*
        * Next: see ConsumerExample
        *
        * */
    }
}


@FunctionalInterface
interface Checker<T> {
    boolean check(T input);
}
