package streams.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7 {


    List<String> getTopUsersWithMostFriends(List<User> users) {
        // 1. sort users by their number of friends
        // 2. pick the top 3 users
        // 3. return their names
        return users.stream()
                .sorted(Comparator.comparing(u -> u.getFriends().size(), Comparator.reverseOrder())) // Stream<User>
                .limit(3) // Stream<User>
                .map(User::getName) // Stream<String>
                .collect(Collectors.toList());
    }

    @Test
    void testGetTopUsersWithMostFriends() {
        User alice = new User("Alice", 20, List.of());
        User bob = new User("Bob", 22, List.of(alice));
        User carol = new User("Carol", 25, Arrays.asList(alice, bob));
        User dave = new User("Dave", 26, Arrays.asList(bob, carol));
        User eve = new User("Eve", 28, List.of(dave, bob, carol));

        List<User> users = Arrays.asList(alice, bob, carol, dave, eve);
        List<String> actual = getTopUsersWithMostFriends(users);

        List<String> expected = Arrays.asList("Carol", "Dave", "Eve");
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.contains("Carol"));
        assertTrue(actual.contains("Dave"));
        assertTrue(actual.contains("Eve"));

    }

    static class User {
        private String name;
        private int age;
        private List<User> friends;

        public User(String name, int age, List<User> friends) {
            this.name = name;
            this.age = age;
            this.friends = friends;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<User> getFriends() {
            return friends;
        }
    }

}
