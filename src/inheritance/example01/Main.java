package inheritance.example01;

// Inhertiance is the process of creating a new class from an existing class.
// we can create a new class that inherits all the properties/methods of the existing class.
public class Main {
    public static void main(String[] args) {
        Person person = new Person("somePersonName", 10, "Dark Brown");
        person.play();
        Dad dad = new Dad("John", 45, "Black");
        dad.play();
        dad.work();
        // person.work();  This proves below statement:
        // Every child/subclass is ALWAYS a parent/superclass, but the other way around is not right always
        // In this example, every Dad object is also a Person object, but not every person object is a dad object.
        // because dad has work() but person does not have.

        System.out.println("==================");
        person.eat();
        person.play();
        System.out.println(person.getName());

        System.out.println("==================");
        dad.eat();
        dad.play();
        dad.work();
        System.out.println(dad.getName());

        System.out.println("==================");
        Boy boy = new Boy("Rob", 14, "Blonde", "House of Fire");
        boy.eat();
        boy.play();
        boy.work();
        boy.dance();
        System.out.println(boy.getName());
        System.out.println(boy.getFavouriteMusic());
    }
}
