package generics;

/*
 * ==============================================================================================
 *                                      Generics
 * ==============================================================================================
 *
 * Generics are a way to create reusable code that can be used with different types.
 * A generic type is a generic class or interface that is parameterized over types.
 *
 * There is a convention that the parameterized type name is a single uppercase letter.
 * Also, there is a convention specifying which letter should be used:
 *  E, T - element type
 *  K - key type
 *  V - value type
 *  T - type
 *  N - number type
 *  S, U, V if there are more parameterized types
 */

import collections.exercise.Person;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        GenericBox<Car> boxWithACar = new GenericBox<>(car); // Here, GenericBox supports only objects of type Car or any subclasses of Car

        Garage<Vehicle> garage = new Garage<>(car);

        // below is not possible since Garage T is limited to Vehicle or subclasses of Vehicle
        // Garage<Person> garage1 = new Garage<Person>();
        garage.repairVehicle();


        LuxuryCar luxuryCar = new LuxuryCar();

        // Since not every Car is a LuxuryCar, then below is not compiling and is incorrect
        // GenericBox<LuxuryCar> box2 = new GenericBox<>(car); // Here we are limiting box2 to only accept instances of LuxuryCar in its constructor

        // Below, we can pass any subclasses of Car to the GenericBox constructor
        GenericBox<? extends Car> box1 = new GenericBox<>(car);
        GenericBox<? extends Car> box2 = new GenericBox<>(luxuryCar);

        // Below you can't pass any subclass of LuxuryCar to the constructor
        // Below you are limited only to pass LuxuryCar or any superclasses of it like Car or Vehicle
        GenericBox<? super LuxuryCar> box3 = new GenericBox<>(luxuryCar);
        GenericBox<? super LuxuryCar> box4 = new GenericBox<>(car);


        // TODO: Generic Challenge
        // Create a generic class to implement a league table for a sport.
        // The class should allow teams to be added to the list, and store
        // a list of teams that belong to the league.
        //
        // Your class should have a method to print out the teams in order,
        // with the team at the top of the league printed first.
        //
        // Only teams of the same type should be added to any particular
        // instance of the league class - the program should fail to compile
        // if an attempt is made to add an incompatible team.
    }
}
