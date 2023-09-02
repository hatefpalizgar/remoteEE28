package functional_interfaces.method_references;


/**
 * <h1>Method reference to a static method of a class</h1>
 */
public class Example02 {
    public static void main(String[] args) {
        Calculator calculator = (numA, numB) -> numA * numB;  // impl.1 using lambda expression

        // impl.2 using method references
        Calculator calculator2 = Multiplication::multiply;

        int result = calculator2.calculate(11,5);

        System.out.println(result); // 55

    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}


class Multiplication {
    public static int multiply(int a, int b) {
        return a * b;
    }
}