package functional_interfaces.method_references;

import java.util.Arrays;

/**
 * <h1>
 * Method reference to an instance method of an arbitrary object of a particular type
 * </h1>
 **/
public class Example03 {
    public static void main(String[] args) {
        String[] arr = {"Steve", "Rick", "Aditya", "Negan", "Lucy", "Sam", "John"};

        // approach.1: using lambda expression for Comparator argument
        Arrays.sort(arr,   (str1, str2) -> str1.compareToIgnoreCase(str2)       );

        // approach.2: using method references
        Arrays.sort(arr, String::compareToIgnoreCase);
    }
}
