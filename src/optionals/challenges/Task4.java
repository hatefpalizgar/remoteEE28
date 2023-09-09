package optionals.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Task4 {
    public static Optional<Integer> square(Optional<Integer> numOpt) {
        return numOpt.map(n -> n * n);
    }
}

class TestTask4 {
    @Test
    public void testSquareWithPresentValue() {
        // Given
        Optional<Integer> numOpt = Optional.of(5);

        // When
        Optional<Integer> resultOpt = Task4.square(numOpt);

        // Then
        Assertions.assertTrue(resultOpt.isPresent());
        Assertions.assertEquals(25, resultOpt.get());
    }

    @Test
    public void testSquareWithEmptyValue() {
        // Given
        Optional<Integer> numOpt = Optional.empty();

        // When
        Optional<Integer> resultOpt = Task4.square(numOpt);

        // Then
        Assertions.assertFalse(resultOpt.isPresent());
    }
}
