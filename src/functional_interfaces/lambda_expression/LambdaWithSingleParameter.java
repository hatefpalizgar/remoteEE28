package functional_interfaces.lambda_expression;

public class LambdaWithSingleParameter {
    public static void main(String[] args) {

        // if your lambda expression/function takes only one single argument,
        // you can remove the parenthesis around input arg/param

        IncrementFunctionalInterface f = number -> number + 5;

        IncrementFunctionalInterface g = (count) ->  count + 7;


        System.out.println(f.increment(14)); // 19

        System.out.println(g.increment(22)); // 29
    }

    /*
    * Next: see LambdaWithMultipleParameters
    * */
}


@FunctionalInterface
interface IncrementFunctionalInterface {
    // an abstract method with one argument
    int increment(int num);
}