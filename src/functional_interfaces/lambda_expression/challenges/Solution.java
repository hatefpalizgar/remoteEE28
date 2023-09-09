package functional_interfaces.lambda_expression.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
//        Task 1
//        Runnable runnable = () -> {
//            String myString = "Let's split this up into an array";
//            String[] parts = myString.split(" ");
//            for (String part : parts) {
//                System.out.println(part);
//            }
//        };


//        Task 2
        Function<String, String> lambdaFunction = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

//        Task 3
        System.out.println(lambdaFunction.apply("1234567890"));

//        Task 4
        String result = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(result);

//       Task 5
        Supplier<String> iLoveJava = () -> "I love Java!";

//        Task 6
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);  // I love Java!

//        Task 8
        List<String> topNames = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        List<String> firstUpperCaseList = new ArrayList<>();

        topNames.forEach(name -> firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort( (s1,s2) -> s1.compareTo(s2)   );

        firstUpperCaseList.forEach(name -> System.out.println(name));

        /*
         * Task #10:
         * Now do the same thing (uppercase first letter, sort and print) using
         * a stream and a chain of stream operations.
         * */
        topNames.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted()
                .forEach(System.out::println);

        /*
         * Task #11:
         * Instead of printing out the sorted names, print out how many names begin with the letter 'A'
         *
         * Hints:
         * - You'll have to modify the stream chain
         * - You'll have to add another statement to print the number of items. You can't print it as part of the stream chain.
         * */
        long namesBeginningWithA = topNames.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("Number of names beginning with A is: " + namesBeginningWithA);

        /*
        * Task #12:
        * Let's go back to the previous version of the code, when we were printing out the sorted names (Task #10).
        * Let's suppose we want to debug what's going on when the chain is executed.
        *
        * Instead of printing out the names at the end of the chain, maybe we're not sure if the code that uppercases the first letter
        * is working correctly.
        *
        * Let's use peek() to print out the names after the map() method has executed.
        *
        * What will the following code print to the console?
        *
         */
        topNames.stream()
                .peek(name -> System.out.println("before map(): " + name))
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(name -> System.out.println("after map(): " + name))
                .sorted();

        // above prints nothing. The chain doesn't contain a terminal operation, so peek() won't work.
        // Remember that stream chains are evaluated lazily. Nothing happens until a terminal operation is added.

        // to fix this:
        topNames.stream()
                .peek(name -> System.out.println("before map(): " + name))
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(name -> System.out.println("after map(): " + name))
                .sorted()
                .collect(Collectors.toList());
    }


    public static String everySecondCharacter(Function<String, String> func, String text) {
        return func.apply(text);
    }

}

