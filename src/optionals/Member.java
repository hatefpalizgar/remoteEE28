package optionals;

import java.util.Optional;

public class Member {
    private String name;
    private Optional<String> email;

    public Member(String name, Optional<String> email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email=" + email.orElse("default@gmail.com") +
                '}';
    }
}
