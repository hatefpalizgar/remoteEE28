package optionals.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Task6 {
    public static Optional<Integer> getMax(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(Collections.max(numbers));
        }
    }
}

class TestTask6 {
    @Test
    public void testGetMaxWithNonEmptyList() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 5, 4, 3);

        // When
        Optional<Integer> result = Task6.getMax(numbers);

        // Then
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(5, result.get());
    }

    @Test
    public void testGetMaxWithEmptyList() {
        // Given
        List<Integer> numbers = new ArrayList<>();

        // When
        Optional<Integer> result = Task6.getMax(numbers);

        // Then
        Assertions.assertFalse(result.isPresent());
    }
}
