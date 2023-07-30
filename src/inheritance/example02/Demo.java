package inheritance.example02;

public class Demo {
    public static void main(String[] args) {
        Car aCar = new Car("Ford");
        System.out.println(aCar.getModel());
        aCar.turnOnEngine();

        System.out.println("=========================");
        // any instance of SportCar inherits everything from its parent Car class
        // any SportCar is ALWAYS a Car as well
        // BUT, we can not say any Car is also a SportCar
        SportCar aSportCar = new SportCar("Toyota");
        System.out.println(aSportCar.getModel());
        aSportCar.turnOnEngine();
        aSportCar.boostSpeed();

        System.out.println("=========================");
        // any SportCar is ALWAYS a Car as well
        Car bSportCar = new SportCar("Subaru");
        bSportCar.turnOnEngine();  // invoked turnOnEngine() in SportCar class
        // bSportCar.boostSpeed();  // compiler error

        System.out.println("=========================");
        Car cSportCar = new UltraSportCar("Porsche", "Nitro-123");
        // cSportCar.getNitrogenType(); // compiler error

        System.out.println("=========== POLYMORPHISM ==============");
        igniteEngine(aSportCar); // aSportCar is also a Car
        igniteEngine(bSportCar); // invoked turnOnEngine() in SportCar class
        igniteEngine(cSportCar); // invoked turnOnEngine() in UltraSportCar class

    }

    public static void igniteEngine(Car someCar) {
        someCar.turnOnEngine();
    }

}
