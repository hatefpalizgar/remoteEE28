package anonymous_class;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        /* ========== Anonymous class using Abstract class ========== */

        Animal kitty = new Cat("Kitty"); // here, the class name is Cat


        // Abstract class can't be instantiated
        // below is an ad-hoc object creation
        // below we're TRYING to instantiate an object using Animal
        // Here we're creating an instance of an object that extends Animal(abstract) with the specified name 'dog'
        // and at the same time providing implementation of the makeSound() method
        Animal dog = new Animal(" Rex") {
            @Override
            public void makeSound() {
                System.out.println("Woof Woof");
            }
        };

        // NB! 'dog' is the name of instance variable we have created NOT the name of the class
        // The class has no name (anonymous)

        dog.makeSound(); // Woof Woof

        // dog object is an instance of a class with no name that extends Animal
        // so, it doesn't mean that dog class in Animal, instead, dog class has no name but it's a subclass of Animal



        // Anonymous class can be useful when you need to use a class just once, or when you need to override just
        // a few methods of a class or interface.

        // Cons:
        // They make code less readable, especially if the anonymous class is large or has lots of methods.

        // FYI, later we will use anonymous class concept in Lambda expression.



        /* ========== Anonymous class using interface ========== */
        // similar to abstract class, we can't instantiate interfaces.
        // Playable toy = new Playable(); // not possible
        Playable toy = new Playable() {
            @Override
            public void play() {
                //...
            }
        };

        toy.play();


        // =================================== Button Example from JavaFX ===============================
        Button button = new Button("Click me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        });


        // OR without using anonymous class
        MyButtonListener listener = new MyButtonListener();
        button.addActionListener(listener);


    }
}

// =================================== Button Example from JavaFX ===============================

class MyButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button clicked");
    }
}
