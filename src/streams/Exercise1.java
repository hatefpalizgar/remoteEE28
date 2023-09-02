package streams;

import streams.example.no1.Example01;

import java.util.Arrays;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Sarah", "Mark", "Tyla", "Ellisha", "Eamonn");

        // a: sort the list and print it out
        names.stream()
                .sorted()
                .forEach(System.out::println);


        // b: print only those names that start with 'E' letter
        names.stream()
                .filter(n -> n.startsWith("E"))
                .forEach(System.out::println);

        // d: print all names in uppercase format
        names.stream()
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);

        /**
         * @see Example01
         * */

    }
}
