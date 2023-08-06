package nested_class;


/*
 * In Java, it is possible to declare classes inside other classes.
 * We call these classes 'nested class'. They can be declared as:
 *   1. static class (so-called static nested class), using the static keyword.
 *   2. non-static class (so-called non-static or inner class)
 *
 * I suggest to read more in depth examples in the following link: https://docs.java.en.sdacademy.pro/javaAdvanced/inner_classes/#inner-classes
 * Also once mastered the concepts of inner classes, take a look at 'local classes' here: https://docs.java.en.sdacademy.pro/javaAdvanced/local_classes/#local-classes
 * */
public class Bicycle {
    private double maxSpeed = 40;

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public class Wheel {
        public void slowDown() {
            // we can refer to outer class's field
            maxSpeed *= 0.5;
            System.out.println("Wheel's max speed is now: " + maxSpeed);
        }

    }// end of Wheel class (inner class)


    public static class StaticNestedClass {
        // can't access outer class instance fields/methods
        // maxSpeed = 10;  maxSpeed unknown to this static class
        public void doNothing() {
            System.out.println("I am a static inner class");
        }
    } // end of StaticNestedClass

} // end of Bicycle class (outer class)
