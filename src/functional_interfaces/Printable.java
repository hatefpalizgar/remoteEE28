package functional_interfaces;

/*
 * Functional interface is an interface with EXACTLY one ABSTRACT method
 * @FunctionalInterface is added so that we can mark an interface as functional
 *
 * a functional interface can contain any number of default or static methods
 * a functional interface can only extend another interface ONLY when the parent interface does not have any abstract method
 *
 * We have JDK built-in functional interfaces like Runnable, Callable, Comparator, ActionListener etc.
 * */

@FunctionalInterface
public interface Printable {
    void print(String message);

    default void someMethod() {
        // default methods are allowed in functional interfaces
    }

    default void anotherMethod() {

    }

    static void save() {
        // static methods are allowed in functional interfaces
    }

}
