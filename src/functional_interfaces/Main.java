package functional_interfaces;

public class Main {
    public static void main(String[] args) {
//        Printable printable = new Printable() {
//            @Override
//            public void print(String message) {
//                System.out.println(message);
//            }
//        };

        // Since Printable is a functional interface, above can be re-written like below:
        // Lambda token: ->
        // Left side of token: list all the input arguments to the method
        // Right side of token: the body of the abstract method

        Printable printable = msg -> {
            System.out.println(msg);
        };

        printable.print("Hello World");

        /*
        * Next: see LambdaWithNoParameter
        * */


    }
}
