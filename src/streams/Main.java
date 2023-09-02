package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person a = new Person("Thomas", "Peterson", 30);
        Person b = new Person("Thomas", "Blau", 45);
        Person c = new Person("Henry", "Smith", 23);
        Person d = new Person("Mike", "Doe", 24);
        Person e = new Person("Mary", "Williams", 58);

        List<Person> applicants = Arrays.asList(a, b, c, d, e);

        // scenario: get the average age of people with firstname Thomas

        // first solution: prior to Java 8
        double avg = 0;
        int sum = 0;
        int count = 0;
        for (Person p : applicants) {
            if (p.getFirstname().equals("Thomas")) {
                count++;
                sum = sum + p.getAge();
            }
        }

        avg = (double) sum / count;

        System.out.println("Average age: " + avg);  // 37.5


        // second solution: post Java 8 - using Streams API
        Stream<Person> applicantsStream = applicants.stream();

        Stream<Person> applicantsStreamAfterFilter = applicantsStream.filter( p -> p.getFirstname().equals("Thomas"));

        Stream<Integer> applicantsStreamOfAges = applicantsStreamAfterFilter.map( p -> p.getAge());

        Double average = applicantsStreamOfAges.collect(Collectors.averagingInt(age -> age.intValue()));

        System.out.println("Average age: " + average);


        // a more simplified version of the second solution
        Double averageV2 = applicants.stream()
                .filter( p -> p.getFirstname().equals("Thomas"))
                .map( p -> p.getAge())
                .collect(Collectors.averagingInt(age -> age.intValue()));


        // another example of working with Streams API
        applicants.stream()
                .sorted( (p1, p2) -> p1.getLastname().compareToIgnoreCase(p2.getLastname()))
                .forEach( p -> System.out.println(p.getLastname()));




        // ==================== another example ==============================
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        // scenario: print out bingo numbers that start with 'G' or 'g' in a sorted way

        // prior to Java 8 solution
        List<String> gNumbers = new ArrayList<>();
        someBingoNumbers.forEach( number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
               // System.out.println(number);
            }
        });

        gNumbers.sort( (s1,s2) -> s1.compareToIgnoreCase(s2));
        gNumbers.forEach(s -> System.out.println(s));

        System.out.println("=========================");

        // post Java 8 using Streams API solution
        someBingoNumbers.stream()
                .filter(s -> s.startsWith("G") || s.startsWith("g"))
                .sorted()
                .forEach(System.out::println);

        /**
         * @see Exercise1
         * */

    }
}
