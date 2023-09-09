package streams.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;


public class Exercise1 {
    /**
     * Task 1: Given a list of integers, return the sum of all the even numbers in the list using the Stream API.
     * If the input list is null, return 0.
     */
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertEquals(30, sumOfEvenNumbers(numbers));
        Assertions.assertEquals(0, sumOfEvenNumbers(null));
        Assertions.assertEquals(0, sumOfEvenNumbers(Collections.emptyList()));
        Assertions.assertEquals(8, sumOfEvenNumbers(Arrays.asList(1, 3, 5, 2, 6)));
    }

    /**
     * Task 2: Given a list of strings, return a list of all strings that start with the letter "a" and have exactly 3 characters
     * using the Stream API. The resulting list should be sorted alphabetically.
     * If the input list is null, return an empty list.
     */
    public static List<String> stringsStartingWithA(List<String> strings) {
        if (strings == null) {
            return Collections.emptyList();
        }
        return strings.stream()
                .filter(s -> s.startsWith("a") && s.length() == 3)
                .sorted()
                .collect(Collectors.toList());
    }

    @Test
    public void testStringsStartingWithA() {
        List<String> strings = Arrays.asList("abcd", "abbc", "add", "aac", "aad");
        Assertions.assertEquals(Arrays.asList("aac", "aad", "add"), stringsStartingWithA(strings));
        Assertions.assertEquals(Collections.emptyList(), stringsStartingWithA(null));
        Assertions.assertEquals(Collections.emptyList(), stringsStartingWithA(Collections.emptyList()));
        Assertions.assertEquals(Collections.singletonList("abc"), stringsStartingWithA(Collections.singletonList("abc")));
    }

    /**
     * Task 3: Given a list of strings, return the number of distinct words (ignoring case) in the list using the Stream API.
     * If the input list is null, return 0.
     */
    public static int countDistinctWords(List<String> strings) {
        if (strings == null) {
            return 0;
        }
        return (int) strings.stream()
                .map(String::toLowerCase)
                .distinct()
                .count();
    }

    @Test
    public void testCountDistinctWords() {
        List<String> strings = Arrays.asList("Hello", "hello", "WORLD", "world", "world");
        Assertions.assertEquals(2, countDistinctWords(strings));
        Assertions.assertEquals(0, countDistinctWords(null));
        Assertions.assertEquals(0, countDistinctWords(Collections.emptyList()));
        Assertions.assertEquals(1, countDistinctWords(Collections.singletonList("hello")));
    }

    /**
     * Task 4: Given a list of strings, return a map where the keys are the length of each string,
     * and the values are a list of strings with that length, sorted alphabetically.
     * If the input list is null, return an empty map.
     */
    public static Map<Integer, List<String>> groupStringsByLength(List<String> strings) {
        if (strings == null) {
            return Collections.emptyMap();
        }
        return strings.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
    }

    @Test
    public void testGroupStringsByLength() {
        List<String> strings = Arrays.asList("a", "bb", "ccc", "dddd", "eeeee");
        Map<Integer, List<String>> expected = new TreeMap<>();
        expected.put(1, Collections.singletonList("a"));
        expected.put(2, Collections.singletonList("bb"));
        expected.put(3, Collections.singletonList("ccc"));
        expected.put(4, Collections.singletonList("dddd"));
        expected.put(5, Collections.singletonList("eeeee"));
        Assertions.assertEquals(expected, groupStringsByLength(strings));
        Assertions.assertEquals(Collections.emptyMap(), groupStringsByLength(null));
        Assertions.assertEquals(Collections.emptyMap(), groupStringsByLength(Collections.emptyList()));
    }

    /**
     * Task 5: Given a list of integers, return the product of all the numbers in the list that are greater than 10
     * and less than 100 using the Stream API. If there are no numbers in the list that meet these criteria,
     * return 1. If the input list is null, return 0.
     */
    public static int productOfNumbersBetweenTenAndHundred(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }
        return numbers.stream()
                .filter(n -> n > 10 && n < 100)
                .reduce(1, (a, b) -> a * b);
    }

    @Test
    public void testProductOfNumbersBetweenTenAndHundred() {
        List<Integer> numbers = Arrays.asList(1, 5, 12, 25, 50, 100);
        Assertions.assertEquals(15000, productOfNumbersBetweenTenAndHundred(numbers));
        Assertions.assertEquals(1, productOfNumbersBetweenTenAndHundred(Collections.emptyList()));
        Assertions.assertEquals(0, productOfNumbersBetweenTenAndHundred(null));
        Assertions.assertEquals(1, productOfNumbersBetweenTenAndHundred(Arrays.asList(1, 2, 3)));
    }
}
