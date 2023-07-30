package inheritance.example02;

public class UltraSportCar extends SportCar{
    // UltraSportCar is a SportCar as well.
    // UltraSportCar is a Car as well.
    private String nitrogenType;

    public UltraSportCar(String model, String nitrogenType) {
        super(model);
        this.nitrogenType = nitrogenType;
    }

    public String getNitrogenType() {
        return nitrogenType;
    }

    @Override
    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() in UltraSportCar class");
    }
}
