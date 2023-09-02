package optionals;

import java.util.Optional;

public class Main {
    public static void main1(String[] args) {

        // Why Optionals?
        User vipUser = new User();

        // String isoCode = vipUser.getAddress().getCountry().getIsoCode();  // throws NPE

        // one way to avoid NPE, is to do null check for every single object
        if (vipUser != null) {
            Address address = vipUser.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String isoCode = country.getIsoCode();
                }
            }
        }

        // Here is what Optionals come to our rescue. We can write the same logic above using Optionals
        String isoCode = Optional.ofNullable(vipUser.getAddress())
                .map(Address::getCountry)
                .map(Country::getIsoCode)
                .orElse("no isoCode");


        Integer number = 5;

        // If number contains a value, anotherNumber will get the same value
        Optional<Integer> anotherNumber = Optional.ofNullable(number);

        System.out.println(anotherNumber);  // Optional[5]


        // otherwise, if number is null, anotherNumber will become 'empty' (NOT null this time because of ofNullable())
        number = null;
        anotherNumber = Optional.ofNullable(number);

        System.out.println(anotherNumber); // Optional.empty


        // Second way of creating Optional
        // using of() method you have to be sure that its argument is a non-null object
        // Optional<Integer> someNumber = Optional.of(number); // throws NPE because number is null

        // We can check if an Optional contains a value or not using isPresent()
        if (anotherNumber.isPresent()) {
            System.out.println(anotherNumber.get());  // use get() to unwrap the value inside an Optional
        } else {
            System.out.println("anotherNumber is empty");
        }

        // How to create an empty Optional using empty() method
        User user = new User();
        Optional<User> emptyUser = Optional.empty();
        // emptyUser.get(); // throws NoSuchElementException because emptyUser is empty


        // What's the difference between Optional.of() and Optional.ofNullable()
        User anotherUser = null;
        // Optional<User> opt = Optional.of(anotherUser);  // if anotherUser is null, we get NPE
        Optional<User> opt2 = Optional.ofNullable(anotherUser); // if anotherUser is null, we get Optional.empty. no NPE

        // How to return default value using Optionals?
        User someUser = null;
        User defaultUser = Optional.ofNullable(someUser).orElse(new User());  // if someUser is empty, returns a new User by default
        System.out.println(defaultUser);


        // How to transform Optional values?
        Country estonia = new Country();
        estonia.setIsoCode("EE");

        Address address = new Address();
        address.setCountry(estonia);

        User eeUser = new User();
        eeUser.setAddress(address);

        Optional<User> eeUserOpt = Optional.ofNullable(eeUser);
        // below we will convert Optional<User> to Optional<Address>
        Optional<Address> addressOpt = eeUserOpt.map(user1 -> user1.getAddress());
        Address eeUserAddress = addressOpt.get();

    }

    public static void main(String[] args) {
        Player player = new Player("John", "john@gmail.com");

        // wrap any object inside an Optional using of() or ofNullable()
        Optional<Player> optionalPlayer = Optional.ofNullable(player);

        // unwrap an object inside an Optional using get()
        Player extractedPlayer = optionalPlayer.get();

        // check if an Optional contains a value or not
        System.out.println(optionalPlayer.isPresent());  // true

        // execute a logic if an Optional contains a value using ifPresent()
        optionalPlayer.ifPresent(p -> System.out.println(p.getEmail()));

        // returning default value
        Optional<Player> emptyPlayerOptional = Optional.empty();
        Player defaultPlayer = emptyPlayerOptional.orElse(new Player("default", "default@gmail.com"));


        // Transform values using map()
        String email = optionalPlayer // Optional<Player>
                .map(p -> p.getEmail())  // Optional<String>
                .get(); // String


        // flatMap() is useful when you are dealing with objects that have their fields as Optional
        // For example, in our code, if the Player class had its 'email' field declared as 'Optional<String>' rather than 'String'
        // we had to use flatMap() instead of map(). Let's create a new class called Member with Optional<String> email field and try
        // to get its email using flatMap() as below:
        Member member = new Member("John", Optional.of("john@gmail.com"));
        Optional<Member> memberOpt = Optional.of(member);

        Optional<String> emailOpt = memberOpt
                .flatMap(m -> m.getEmail()); // Optional<Optional<String>>

        System.out.println(emailOpt);

        // Filtering values using filter()
        Optional<Player> filteredPlayer = optionalPlayer.filter(p -> p.getEmail().contains("gmail"));
        // Above line in simple term:
        // If optionalPlayer contains a player object which has its email containing 'gmail', then it will return that optional player
        // object otherwise it will return an empty optional
        System.out.println(filteredPlayer.isPresent()); // true

        /*
         * NB! Please read more about Optionals here: https://stackify.com/optional-java/
         */
    }
}
