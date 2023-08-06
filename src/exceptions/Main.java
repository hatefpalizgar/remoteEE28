package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main1(String[] args) {
        int[] array = {1, 2, 3, 4, 5};  // maximum index value is 4
        System.out.println(array[8]); // this line throws ArrayIndexOutOfBoundsException

        System.out.println("This line never gets executed");
    }

    public static void main2(String[] args) {
        int a = 10;
        int b = 0;

        // try-catch block (exception handler)
        try {
            System.out.println(a / b); // this line throws ArithmeticException
            System.out.println("This line never gets executed"); // no line after the exception-throwing line will be executed
        } catch (ArithmeticException ex) {
            System.out.println("Exception caught: " + ex);
        }

        System.out.println("This line should be executed");
    }

    /* ========================================================================================== */
    //                                  Exception Hierarchy
    /* ========================================================================================== */

    // https://rollbar.com/blog/java-exceptions-hierarchy-explained/
    // https://facingissuesonit.com/java-exception-handling/


    /* ========================================================================================== */
    //                            Checked vs. Unchecked Exceptions
    /* ========================================================================================== */
    // 4. Checked(compile-time) and unchecked(runtime) exceptions
    // 4.a. Checked exceptions are checked at compile time.
    // Classes that directly inherit Throwable except RuntimeException and Error e.g. IOException, InterruptedException
    // 4.b. Unchecked exceptions are not checked at compile time. Classes that inherit RuntimeException
    // are unchecked exceptions like ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException, etc.

    // Google: Compare Error vs. Exception


    /* ========================================================================================== */
    //                       Handling multiple exceptions using Pipe operator
    /* ========================================================================================== */
    public static void main3(String[] args) {
        try {
            int[] array = {1, 2, 3, 4, 5};
            System.out.println(array[19]);  // this throws ArrayIndexOutOfBoundsException
            System.out.println(10 / 0); // this throws ArithmeticException
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        }
    }



    /* ========================================================================================== */
    //                    Handling multiple exceptions using multiple catch blocks
    /* ========================================================================================== */

    // Let's say you want to catch each exception in a different way

    public static void main4(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        try {
            int result = 10 / 0;  // throws ArithmeticException
            System.out.println(array[11]);  // throws ArrayIndexOutOfBoundsException
            System.out.println("This will never execute");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e);
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException caught: " + ex);
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex);
        }

        System.out.println("Hello World");
    }

    /* ========================================================================================== */
    //                                 How to throw exception
    /* ========================================================================================== */
    public static void main5(String[] args) {
        try {
            someMethod(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Welcome to Testing a Washing Machine");
    }

    public static void someMethod(boolean isTurnedOn) throws Exception {
        if (isTurnedOn) {
            System.out.println("Washing machine is turned on");
        } else {
            System.out.println("Washing machine is turned off");
            throw new Exception("A turned off machine can't be tested");
        }
    }


    /* ========================================================================================== */
    //                                    Finally Block
    /* ========================================================================================== */
    public static void main6(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        try {
            System.out.println(array[9]);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            System.out.println("I want this line to always run, no matter exception occurs or not");
        }

        System.out.println("This never prints anything");

    }

    /* ========================================================================================== */
    //                                    Try with resources
    /* ========================================================================================== */

    // With try-with-resource you no longer need to close the resource yourself, it will be automatically handled.
    // Read more: https://www.baeldung.com/java-try-with-resources
    public static void main7(String[] args) {
        try (FileReader fr = new FileReader("src/exceptions/non-exist.jpg")) {
            // the logic for reading the file goes here...
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* ========================================================================================== */
    //                                    Custom Exceptions
    /* ========================================================================================== */

    public static void main(String[] args) {
        aMethodThatThrowsCustomException();
    }

    public static void aMethodThatThrowsCustomException() {
        throw new PasswordNotFoundException("Password is invalid");
    }

}
