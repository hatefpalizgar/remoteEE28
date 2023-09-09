package optionals.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Task9 {
    public static Optional<Integer> getStringLength(String str) {
        return Optional.ofNullable(str)
                .map(String::length);
    }
}


class TestTask9 {
    @Test
    public void testGetStringLengthWithNonNullString() {
        // Given
        String str = "Hello, world!";

        // When
        Optional<Integer> result = Task9.getStringLength(str);

        // Then
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(13, result.get());
    }

    @Test
    public void testGetStringLengthWithNullString() {
        // Given
        String str = null;

        // When
        Optional<Integer> result = Task9.getStringLength(str);

        // Then
        Assertions.assertFalse(result.isPresent());
    }
}
