package streams.challenges;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise2 {
    /**
     * Task 1:
     * Given a list of strings, return the longest string.
     * If there are multiple longest strings, return the first one.
     */
    public static String longestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    @Test
    public void testLongestString() {
        List<String> strings = List.of("one", "two", "three", "four", "five");
        assert longestString(strings).equals("three");
        assert longestString(Collections.emptyList()).equals("");
    }

    /**
     * Task 2:
     * Given a list of integers, return a new list where each integer is multiplied by 2.
     */
    public static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
    }

    @Test
    public void testDoubleList() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assert doubleList(numbers).equals(List.of(2, 4, 6, 8, 10));
        assert doubleList(Collections.emptyList()).equals(Collections.emptyList());
    }

    /**
     * Task 3:
     * Given a list of integers, return the sum of all the even numbers in the list.
     */
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    @Test
    public void testSumEvenNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assert sumEvenNumbers(numbers) == 30;
        assert sumEvenNumbers(Collections.emptyList()) == 0;
    }

    /**
     * Task 4:
     * Given a list of strings, return a map where the keys are the lengths of the strings,
     * and the values are the list of strings with that length, sorted in descending order.
     */
    public static Map<Integer, List<String>> groupByLengthDescending(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()))
                .descendingMap();
    }

    @Test
    public void testGroupByLengthDescending() {
        List<String> strings = List.of("one", "two", "three", "four", "five");
        Map<Integer, List<String>> result = groupByLengthDescending(strings);
        assert result.get(3).equals(List.of("one", "two"));
        assert result.get(4).equals(List.of("four", "five"));
        assert result.get(5).equals(List.of("three"));
        assert result.size() == 3;
        assert groupByLengthDescending(Collections.emptyList()).isEmpty();
    }

    /**
     * Task 5:
     * Given a list of strings, return the concatenation of all the strings that have length greater than 3
     * and start with the letter 'a', separated by a comma.
     */
    public static String concatFilteredStrings(List<String> strings) {
        return strings.stream()
                .filter(str -> str.length() > 3 && str.startsWith("a"))
                .collect(Collectors.joining(","));
    }

    @Test
    public void testConcatFilteredStrings() {
        List<String> strings = List.of("apple", "banana", "avocado", "orange", "apricot");
        assert concatFilteredStrings(strings).equals("apple,avocado,apricot");
        assert concatFilteredStrings(Collections.emptyList()).isEmpty();
    }
}
