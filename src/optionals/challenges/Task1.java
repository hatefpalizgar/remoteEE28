package optionals.challenges;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1 {
    public static Optional<Integer> parseInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

class TestTask1 {
    @Test
    void testParseInt() {
        Optional<Integer> numOpt1 = Optional.of(123);
        Optional<Integer> numOpt2 = Optional.empty();

        assertEquals(numOpt1, Task1.parseInt("123"));
        assertEquals(numOpt2, Task1.parseInt("abc"));
    }
}