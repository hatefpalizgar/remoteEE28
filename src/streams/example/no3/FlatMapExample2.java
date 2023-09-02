package streams.example.no3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * This example uses .stream() to convert a List into a stream of objects, and each object contains a set of books, and we can use flatMap to produces a stream containing all the book in all the objects.
 * In the end, we also filter out the book containing the word python and collect a Set to remove the duplicated book.
 */

public class FlatMapExample2 {
    public static void main(String[] args) {
        Developer o1 = new Developer();
        o1.setName("Tom");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3rd Edition)");

        Developer o2 = new Developer();
        o2.setName("Edward");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3rd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        // hmm... Set of Set... how to process?
        Set<Set<String>> collected = list.stream()
                .map(developer -> developer.getBooks())
                .collect(Collectors.toSet());

        // so flatMap() is a better option when dealing with objects that has fields of aggregate form


        Set<String> collectedV2 = list.stream()
                .map(d -> d.getBooks())  // Stream<Set<String>>
                .flatMap(set -> set.stream()) // Stream<String>
                .filter(x -> !x.toLowerCase().contains("python"))
                .collect(Collectors.toSet());

        System.out.println(collectedV2);

        /*
         * More examples: https://mkyong.com/java8/java-8-flatmap-example/
         */
    }


    static class Developer {
        private Integer id;
        private String name;
        private Set<String> books;

        public void addBook(String book) {
            if (this.books == null) {
                this.books = new HashSet<>();
            }
            this.books.add(book);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<String> getBooks() {
            return books;
        }

        @Override
        public String toString() {
            return "Developer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", book=" + books +
                    '}';
        }
    }
}

