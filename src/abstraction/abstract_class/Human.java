package abstraction.abstract_class;

public abstract class Human {
    private String name;

    public abstract void eat();

    public abstract void breathe();

    // concrete method
    public void walk() {
        System.out.println("walk() method is called");
    }
}
