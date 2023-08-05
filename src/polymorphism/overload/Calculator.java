package polymorphism.overload;

public class Calculator {

    // method to add two integers
    public void add(int a, int b) {
        System.out.println("Addition of two numbers is: " + (a + b));
    }


    // method to add two strings (overloaded version)
    public void add(String a, String b) {
        System.out.println("Addition of two strings is: " + (a + b));
    }
}
