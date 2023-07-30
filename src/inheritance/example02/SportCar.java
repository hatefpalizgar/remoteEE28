package inheritance.example02;

public class SportCar extends Car{
    public SportCar(String model) {
        super(model);
    }

    public void boostSpeed() {
        System.out.println("invoked boostSpeed() in SportCar class");
    }

    @Override
    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() in SportCar class");
    }
}
