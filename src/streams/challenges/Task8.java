package streams.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8 {


    public int parallelStreamProcess(List<Integer> numbers) {
        // 1. map each Integer to it's square value
        // 2. sum these squared values
        return numbers.parallelStream()
                .mapToInt(n -> n * n)
                .sum();
    }

    @Test
    void testSumOfSquares() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int expected = 385; // 1 + 4 + 9 + ... + 100
        int result = parallelStreamProcess(numbers);

        assertEquals(expected, result);
    }

}
