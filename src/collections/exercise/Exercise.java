package collections.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise {
    public static void main(String[] args) {
        Person p1 = new Person("Hatef", "Palizgar", 33);
        Person p2 = new Person("Adam", "Smith", 25);

        Friend f1 = new Friend("John", "Doe", 22);
        Friend f2 = new Friend("Mary", "Abraham", 40);

        Map<Person,Friend> map = new HashMap<>();

        map.put(p1, f1);
        map.put(p2, f2);


        // Now, let's create a map that links more than one friend to a person
        Map<   Person  , List<Friend>> partyPeople = new HashMap<>();
        partyPeople.put(p1, Arrays.asList(f1, f2));
        partyPeople.put(p2, Arrays.asList(f1,f2));

        for(Map.Entry<Person, List<Friend>> entry : partyPeople.entrySet()) {
            List<Friend> friends = entry.getValue();

            for (Friend f: friends) {
                System.out.println(entry.getKey().getFirstname() + ": \n" + f.getFirstname() + " " + f.getLastname() + " " + f.getAge());
            }
        }

    }
}
