package abstraction.interfaces;


// Fields/properties are not allowed in interface
// Methods are PUBLIC and ABSTRACT by default in interface
// Prior to Java 8, only abstract methods were allowed in interfaces.
// But from Java8+, it is also possible to have concrete methods in interfaces
// BUT, you have to define them as 'default'

// Primarily, interfaces were designed to ONLY have abstract methods.
// If you want to have an interface with default/static methods, prefer to use abstract class.

// Similar to abstract class, you can NOT instantiate or create objects from interface. There is no constructor.

// You should IMPLEMENT an interface


// Interface is a contract
public interface Loveable {

    // abstract
    void love();

    // concrete
    default void someMethod() {
        //...
    }

    // static
    static int getAge() {
        return 0;
    }
}
