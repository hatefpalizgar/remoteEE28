package functional_interfaces.lambda_expression;

public class LambdaWithMultipleParameters {
    public static void main(String[] args) {

        //  lambda expression/function with multiple params/args
        // if your lambda expression is a one-liner (a method body with single line),
        // then you can discard curly braces

        // if your method is returning something, you can remove 'return' keyword
        // and Java returns by default whatever is on the right side of Lambda token
        StringConcatFunctionalInterface s = (str1, str2) -> str1 + str2;

        System.out.println(s.concat("Hello", " World"));
    }
}


@FunctionalInterface
interface StringConcatFunctionalInterface {
    String concat(String a, String b);
}