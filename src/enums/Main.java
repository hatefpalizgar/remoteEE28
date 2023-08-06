package enums;


public class Main {
    public static void main(String[] args) {
        String name = "SDA";
        name = "Hatef";
        name = "123";

        // enum is a special Java construct that can take
        // only a limited set of values

        SimpleUnit unit = SimpleUnit.CENTIMETER;

        System.out.println(unit);

        System.out.println(SimpleUnit.INCH);
        System.out.println(SimpleUnit.FOOT);

        ComplexUnit complexUnit = ComplexUnit.INCH;
        System.out.println(complexUnit.convert());

        Weight weightInKilogram = Weight.KILOGRAM;
        System.out.println(weightInKilogram.value + " " + weightInKilogram.type);


        // let's say you have an application that only accepts a predefined(default) set of colors
        // like red, green, blue
        // Developers and users are not allowed to have any other colors
        System.out.println(Color.RED);
        System.out.println(Color.BLUE);
        System.out.println(Color.GREEN);
        // System.out.println(Color.YELLOW); not possible

        // Ex1. write an application that prints weekdays using Enums
        // also display their corresponding day number (Monday = 1 and so on)
        System.out.println(Weekday.FRIDAY);
        System.out.println(Weekday.FRIDAY.getOrder());
        System.out.println(Weekday.FRIDAY.name());  // displays the name of the enum
        System.out.println(Weekday.FRIDAY.ordinal()); // displays the order of enum value


        // Ex2. Write an application for a traffic light that has RED,GREEN, YELLOW with
        // some message to tell the drivers what to do.
        // Simulate a scenario of red light is turned on
        // Show the driver the message
        System.out.println(TrafficLight.RED.getMessage());

    }
}
