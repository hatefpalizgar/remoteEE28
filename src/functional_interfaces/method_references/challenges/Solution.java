package functional_interfaces.method_references.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {

//        Task 2
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 17));
        personList.add(new Person("Charlie", 30));
        personList.add(new Person("David", 15));
        personList.add(new Person("Eve", 20));

        AgeChecker ageChecker = p -> p.getAge() >= 18;

        personList.stream()
                .filter(ageChecker::isAdult)
                .forEach(p -> System.out.println(p.getName()));


//        Task 3
        StringConverter converter = Person::countVowels;
        int numVowels = converter.convert("Hello, World!");
        System.out.println(numVowels); // 3

//        Task 4
        Calculator calculator = new Calculator(10, 5);

        BinaryOperator adder = Calculator::add;
        BinaryOperator subtractor = Calculator::subtract;
        BinaryOperator multiplier = Calculator::multiply;
        BinaryOperator divider = Calculator::divide;

        int sum = adder.apply(calculator.getNum1(), calculator.getNum2());
        int difference = subtractor.apply(calculator.getNum1(), calculator.getNum2());
        int product = multiplier.apply(calculator.getNum1(), calculator.getNum2());
        int quotient = divider.apply(calculator.getNum1(), calculator.getNum2());

        System.out.println(sum);
        System.out.println(difference);
        System.out.println(product);
        System.out.println(quotient);


//        Task 5
        StringFunction reverser = StringUtils::reverse;

        String reversed = reverser.apply("hello world");
        System.out.println(reversed);  // dlrow olleh

//        Task 7
        Rectangle rectangle = new Rectangle("Rectangle", 5, 3);
        Circle circle = new Circle("Circle", 2.5);

        Function<Rectangle, Double> rectangleArea = Rectangle::getArea;
        Function<Circle, Double> circleArea = Circle::getArea;

        System.out.println(rectangleArea.apply(rectangle));  // 5 * 3 = 15.0
        System.out.println(circleArea.apply(circle)); // PI * 2.5 * 2.5 = 19.634954084936208


//         Task 10
        CarFactory factory = Car::new;

        Car car = factory.create("Toyota", "Camry");

        System.out.println(car);

    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int countVowels(String s) {
        return s.replaceAll("[^aeiouAEIOU]", "") // Hello World --> eoo
                .length();  // 3
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Calculator {
    private int num1;
    private int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}

class StringUtils {
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

class Car {
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

abstract class Shape {
    private String name;
    private double width;
    private double height;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double getArea();
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        // avoid using magic numbers, prefer constants instead
//        return 3.14 * radius * radius;
        return Math.PI * radius * radius;
    }
}


@FunctionalInterface
interface CarFactory {
    Car create(String make, String model);
}

@FunctionalInterface
interface AgeChecker {
    boolean isAdult(Person person);
}


@FunctionalInterface
interface StringConverter {
    int convert(String s);
}

@FunctionalInterface
interface BinaryOperator {
    int apply(int a, int b);
}

@FunctionalInterface
interface StringFunction {
    String apply(String s);
}