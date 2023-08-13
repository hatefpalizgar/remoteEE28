package generics;

// Here we have limited the generic type to only subclasses of Vehicle
public class Garage<T extends Vehicle> {
    private T vehicle;

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }

    public void repairVehicle() {
        this.vehicle.repair();
    }
}
