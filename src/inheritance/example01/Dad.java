package inheritance.example01;

// Class Dad inherits(extends) from class Person
// So, Dad is a Person as well
// Person is the parent/superclass of Dad
// Dad is a child/subclass of Person
public class Dad extends Person {
    public Dad(String name, int age, String hairColor) {
        // The super keyword is used to call the constructor of the superclass
        // It's like calling the constructor of the parent class
        super(name, age, hairColor);
        // If a child is to be born, the parent should be born first
    }

    public void work() {
        System.out.println("Dad is working");
    }

    // I want my Dad class to implement play() different than that of Person

    // Below, we are overriding method play() from Person class
    // This means that play() of Person is overridden by Dad
    // This process is called 'method overriding'
    // So, any instance/object created from Dad can have its own way of playing
    @Override
    public void play() {
        System.out.println("Dad plays with his kids");
    }

    // Putting @Override is optional, but it is recommended and it is a good practice.
    // If you don't put it, you might run into errors that are hard to debug.
    @Override
    public void eat() {
        System.out.println("Dad eats steak");
    }

    // all the getters & setters are inherited from Person class
    // So, we don't need to write them again as they're implicitly inherited.
    // The JVM will automatically generate getters&setters for us during compilation
}
