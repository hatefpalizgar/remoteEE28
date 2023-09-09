package optionals.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Task5 {
    public static List<String> getNonEmptyStrings(List<Optional<String>> stringOpts) {
        List<String> nonEmptyStrings = new ArrayList<>();
        for (Optional<String> stringOpt : stringOpts) {
            stringOpt.ifPresent(nonEmptyStrings::add);
        }
        return nonEmptyStrings;
    }
}

class TestTask5 {
    @Test
    public void testGetNonEmptyStrings() {
        // Given
        List<Optional<String>> stringOpts = new ArrayList<>();
        stringOpts.add(Optional.of("hello"));
        stringOpts.add(Optional.of(""));
        stringOpts.add(Optional.empty());
        stringOpts.add(Optional.of("world"));

        // When
        List<String> nonEmptyStrings = Task5.getNonEmptyStrings(stringOpts);

        // Then
        Assertions.assertEquals(3, nonEmptyStrings.size());
        Assertions.assertTrue(nonEmptyStrings.contains("hello"));
        Assertions.assertTrue(nonEmptyStrings.contains("world"));
        Assertions.assertTrue(nonEmptyStrings.contains(""));
    }
}
