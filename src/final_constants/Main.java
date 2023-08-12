package final_constants;

public class Main {

    /* ========================================================================================== */
    //                                   Java final Variable
    /* ========================================================================================== */
    // In Java, we can NOT change the value of a final variable after it is assigned.
    // It will always contain the same value.

    public static void main1(String[] args) {
        // creating a final variable
        final int age = 32;

        // below is not possible, we get compilation error
        // age = 55;

        // final modifier makes a variable immutable. This means the variable can NOT be mutated(changed)
    }

    /* ========================================================================================== */
    //                                   Java final method
    /* ========================================================================================== */
    // In Java, final method can NOT be overridden by any subclass.
    // Samsung can NOT override display() of it's parent class Monitor


    /* ========================================================================================== */
    //                                   Java final class
    /* ========================================================================================== */
    // In Java, final class can NOT be inherited(extended) by another class.
    // class SmartSamsung can NOT extend Samsung which is a final class




    /* ========================================================================================== */
    //                                        Constants
    /* ========================================================================================== */
    public static void main(String[] args) {
        // to access pi variable, you need to create an instance of Math class
        Math math = new Math();
        System.out.println(math.pi);

        // it doesn't make sense to create an object of Math type each time to just access pi variable.

        // so, I make pi variable a constant by making it 'static final'
        // now, I no longer need to create Math object each time
        // a constant is accessible directly by the class Math
        System.out.println(Math.piV2);

    }

}


class Math {
    final double pi = 3.14;
    // how to declare a constant? (static + final)
    // static: the variable belong to the class, so no need to create an object to access it
    // final: the variable is immutable and it's value can NOT change
    static final double piV2 = 3.14;

    // Naming convention for constants: ALL UPPERCASE
    static final int NUMBER = 1;
}

// below is not possible since a final class can NOT be inherited
//class SmartSamsung extends Samsung {
//
//}

final class Samsung extends Monitor {
    // below is not possible, you can NOT override an inherited final method
//    @Override
//    public final void display() {
//
//    }
}

class Monitor {
    // create a final method
    public final void display() {
        System.out.println("This is a final method");
    }

    public void turnOff() {
        // ...
    }
}