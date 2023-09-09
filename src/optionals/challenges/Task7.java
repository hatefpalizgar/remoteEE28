package optionals.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Task7 {
    public static int getStringLength(Optional<String> strOpt) {
        return strOpt.map(String::length).orElse(-1);
    }
}


class TestTask7 {
    @Test
    public void testGetStringLengthWithPresentString() {
        // Given
        Optional<String> strOpt = Optional.of("hello world");

        // When
        int length = Task7.getStringLength(strOpt);

        // Then
        Assertions.assertEquals(11, length);
    }

    @Test
    public void testGetStringLengthWithEmptyString() {
        // Given
        Optional<String> strOpt = Optional.empty();

        // When
        int length = Task7.getStringLength(strOpt);

        // Then
        Assertions.assertEquals(-1, length);
    }
}