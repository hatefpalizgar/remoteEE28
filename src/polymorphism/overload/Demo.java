package polymorphism.overload;

// Polymorphism:
// Polymorphism is the ability of an object to take on many forms.
// The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.
// In other words, the child class can be used as the parent class.
// This is much like a child can be used as a parent in the real world:
// Let's say you as the child try to show up at the parents' party and all you have to do is to mimic your dad's behaviors.

// In Java, polymorphism is achieved in two ways:
// 1. Method Overloading (compile-time polymorphism)
//    Method overloading happens when various methods with the SAME name but DIFFERENT number, order, or types of parameters
//    are present in a class.
//    Learn more: https://www.softwaretestinghelp.com/polymorphism-in-java/#:~:text=overloading%20in%20general.-,Method%20Overloading%20In%20Java,have%20%E2%80%9Coverloaded%E2%80%9D%20the%20methods
//
// 2. Method Overriding (runtime polymorphism)
//    Method overriding occurs when a child class overrides a method of its parent.
public class Demo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.add(3, 5);  // calls 1st method

        calculator.add("Hello", "World"); // calls 2nd method
    }
}
