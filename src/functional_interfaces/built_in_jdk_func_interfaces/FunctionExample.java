package functional_interfaces.built_in_jdk_func_interfaces;

import java.util.function.Function;


/*
 * Function represents a functional interface that consumes one arg and produces a result
 * Function has a method called 'R apply(T)'
 * */
public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> func = (input) -> input.substring(5);

        String output = func.apply("This is a test Function interface in Java 8");

        System.out.println(output);

        // Function can have different types of input and output
        Function<String, Integer> characterCounter = txt -> txt.length();

        System.out.println(characterCounter.apply("Hello World")); // 11


        /*
        * Next:
        * see method_references package
        * */
    }
}
