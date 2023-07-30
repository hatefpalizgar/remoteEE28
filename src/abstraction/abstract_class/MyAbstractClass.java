package abstraction.abstract_class;

/**
 * Abstract class in Java:
 * 1. should be declared using 'abstract' keyword
 * 2. can have fields
 * 3. can have 0 or more abstract methods
 * 4. can have 0 or more concrete methods
 * */
public abstract class MyAbstractClass {
    private String name;

    public abstract void abstractMethod();  // abstract method: a method without any implementation/body

    public void concreteMethod() {
        System.out.println("inside concreteMethod() of MyAbstractClass");
    }

}
