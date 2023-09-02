package streams.example.no2;

import streams.example.no3.FlatMapExample1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example02 {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        // alternative approach for creating a stream without creating any collection first
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I29", "071");

        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        // A stream without terminal operation will never execute.
        concatStream.peek(number -> System.out.println("number: " + number)).collect(Collectors.toList());

        // Below count() won't execute with peek() because in Java9+, peek() won't work with count()
        // Read more: https://mkyong.com/java8/java-8-stream-the-peek-is-not-working-with-count/
        // concatStream.peek(number -> System.out.println("number: " + number)).count();

        // what is the output?
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() < 4)
                .peek(e -> System.out.println("Filtered Value: " + e))
                .map(e -> e.toUpperCase())
                .peek(e -> System.out.println("Mapped value:" + e))
                .collect(Collectors.toList());

        // Above confirms that for a stream of size 'n', the stream pipeline will execute 'n' times.
        // Pipeline will be executed for each element, from beginning to the end.

        /**
         * @see FlatMapExample1
         * */
    }
}
