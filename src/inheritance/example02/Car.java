package inheritance.example02;

// Every class in Java inherits Object class which is a built-in JDK class
public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() in Car class");
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

}
