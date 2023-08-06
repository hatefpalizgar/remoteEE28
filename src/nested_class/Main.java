package nested_class;

public class Main {
    public static void main(String[] args) {
        // Usually, an inner class is not supposed to be instantiated on its own
        // That's why it's declared as an inner class so that it can be only used by the outer class.
        // BUT, if you still want to do that, then you should instantiate an inner class like below:
        Bicycle myBike = new Bicycle();

        System.out.println("Bike maxSpeed is: " + myBike.getMaxSpeed());

        // weird way of instantiating an inner class
        // there is no point at instantiating an inner class
        Bicycle.Wheel aWheel = myBike.new Wheel();
        aWheel.slowDown();


        // instantiating a static nested class
        Bicycle.StaticNestedClass mySecondObject = new Bicycle.StaticNestedClass();
        mySecondObject.doNothing();
    }
}
