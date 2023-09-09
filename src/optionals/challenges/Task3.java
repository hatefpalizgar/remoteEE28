package optionals.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Task3 {
    public static List<String> getPeopleWithAddress(List<Person> people) {
        List<String> names = new ArrayList<>();
        for (Person person : people) {
            if (person.getAddress().isPresent()) {
                names.add(person.getName());
            }
        }
        return names;
    }
}

class TestTask3 {
    @Test
    void testGetPeopleWithAddress() {
        // Given
        List<Person> people = new ArrayList<>();
        Person person1 = new Person("John", 30);
        person1.setAddress(Optional.of("123 Main St."));
        Person person2 = new Person("Jane", 25);
        person2.setAddress(Optional.empty());
        Person person3 = new Person("Bob", 40);
        person3.setAddress(Optional.empty());
        people.add(person1);
        people.add(person2);
        people.add(person3);

        // When
        List<String> names = Task3.getPeopleWithAddress(people);

        // Then
        Assertions.assertEquals(1, names.size());
        Assertions.assertTrue(names.contains("John"));
    }
}

class Person {
    private String name;
    private int age;
    private Optional<String> address;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = Optional.empty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }
}
