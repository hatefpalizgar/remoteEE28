package functional_interfaces.lambda_expression;

public class LambdaWithNoParameter {
    public static void main(String[] args) {
        // Lambda expression/function with no parameter/arg
        SayHelloFunctionalInterface message = () -> "Hello";

        System.out.println(message.sayHello());


        // How it was prior to lambda/Java8
        SayHelloFunctionalInterface messageOld = new SayHelloFunctionalInterface() {
            @Override
            public String sayHello() {
                return "Hello";
            }
        };

    }

    /*
    * Next: see LambdaWithSingleParameter
    * */

}


@FunctionalInterface
interface SayHelloFunctionalInterface {
    // an abstract method with no input argument
    String sayHello();
}