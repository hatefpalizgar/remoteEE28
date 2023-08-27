package functional_interfaces.built_in_jdk_func_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/*
 * Consumer consumes values. This FI (func. interface) always takes an argument and never returns anything.
 * Consumer has a functional method called 'void accept(T)'
 * */

public class ConsumerExample {
    public static void main(String[] args) {
        // Consumer is a built-in JDK functional interface that only consumes stuff,
        // it doesn't return anything

        Consumer<Teacher> teacherConsumer = (teacher) -> {
            System.out.println(teacher.getName());
            System.out.println(teacher.getAge());
        };

        Teacher mary = new Teacher("Mary", 22);

        teacherConsumer.accept(mary);


        Consumer<String> stringConsumer = str -> System.out.println(str.toUpperCase());
        stringConsumer.accept("hello world");  // HELLO WORLD


        List<Teacher> list = new ArrayList<>();
        list.add(new Teacher("Toby", 23));
        list.add(new Teacher("Rose", 20));
        list.add(new Teacher("Tom", 31));

        // inside forEach() we have to provide an object of type Consumer that consumes every Teacher in the list
        // In other terms, below will execute teacherConsumer.accept(...) with teachers in the list as argument
        list.forEach(teacherConsumer);

        /*
        * Next:
        * see SupplierExample
        * */
    }
}
