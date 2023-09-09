package streams.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task10 {

    public List<String> findCitiesOfJohns(List<Person> people) {
           // 1. filter to find people with name 'John'
           // 2. flatMap to map each person to a stream of its addresses
           // 3. map each address to the city
           // 4. collect and return it as a list
        return people.stream()
                .filter(person -> person.getName().equalsIgnoreCase("john"))  // Stream<Person>
                .flatMap(person -> person.getAddresses().stream())  // Stream<Address>
                .map(Address::getCity)  // Stream<String>
                .collect(Collectors.toList());

    }


    @Test
    void testFindCitiesOfJohns() {
        Address john1Address1 = new Address("123 Main St", "New York", "NY");
        Address john1Address2 = new Address("456 Elm St", "Boston", "MA");
        Person john1 = new Person("John", Arrays.asList(john1Address1, john1Address2));

        Address john2Address1 = new Address("789 Oak St", "Chicago", "IL");
        Address john2Address2 = new Address("321 Maple St", "San Francisco", "CA");
        Person john2 = new Person("John", Arrays.asList(john2Address1, john2Address2));

        Person jane = new Person("Jane", List.of(new Address("111 Pine St", "Seattle", "WA")));

        List<Person> people = Arrays.asList(john1, john2, jane);

        List<String> expected = Arrays.asList("New York", "Boston", "Chicago", "San Francisco");
        List<String> result = findCitiesOfJohns(people);

        assertEquals(expected, result);
    }

    static class Address {
        private String street;
        private String city;
        private String state;

        public Address(String street, String city, String state) {
            this.street = street;
            this.city = city;
            this.state = state;
        }

        public String getCity() {
            return city;
        }
    }

    static class Person {
        private String name;
        private List<Address> addresses;

        public Person(String name, List<Address> addresses) {
            this.name = name;
            this.addresses = addresses;
        }

        public String getName() {
            return name;
        }

        public List<Address> getAddresses() {
            return addresses;
        }
    }
}
