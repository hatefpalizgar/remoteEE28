package optionals.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Task8 {
    public static OptionalDouble averageAgeOfPeopleWithNamePrefix(List<Person> people, String prefix) {
        double ageSum = 0;
        int count = 0;
        for (Person person : people) {
            if (person.getName().startsWith(prefix)) {
                ageSum += person.getAge();
                count++;
            }
        }
        return count > 0 ? OptionalDouble.of(ageSum / count) : OptionalDouble.empty();
    }
}

class TestTask8 {
    @Test
    public void testAverageAgeOfPeopleWithNamePrefixWithMatchingPrefix() {
        // Given
        List<Person> people = Arrays.asList(
                new Person("John", 30),
                new Person("Jane", 25),
                new Person("Joan", 40),
                new Person("Jim", 35)
        );
        String prefix = "Jo";

        // When
        OptionalDouble result = Task8.averageAgeOfPeopleWithNamePrefix(people, prefix);

        // Then
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(35, result.getAsDouble());
    }

    @Test
    public void testAverageAgeOfPeopleWithNamePrefixWithNonMatchingPrefix() {
        // Given
        List<Person> people = Arrays.asList(
                new Person("John", 30),
                new Person("Jane", 25),
                new Person("Joan", 40),
                new Person("Jim", 35)
        );
        String prefix = "Dave";

        // When
        OptionalDouble result = Task8.averageAgeOfPeopleWithNamePrefix(people, prefix);

        // Then
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void testAverageAgeOfPeopleWithNamePrefixWithEmptyList() {
        // Given
        List<Person> people = new ArrayList<>();
        String prefix = "Jo";

        // When
        OptionalDouble result = Task8.averageAgeOfPeopleWithNamePrefix(people, prefix);

        // Then
        Assertions.assertFalse(result.isPresent());
    }
}
