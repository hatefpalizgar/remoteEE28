package class_and_object;

// Create a class with the following properties
// - Name of the building
// - Number of floors
// - Number of rooms
public class Building {
    private String name;
    private int numberOfFloors;
    private int numberOfRooms;


    // Constructor is a special method that is used to initialize the fields/properties/attributes of a class.
    public Building(String name, int numberOfFloors, int numberOfRooms) {
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.numberOfRooms = numberOfRooms;
    }

    // getter methods
    public String getName() {
        return this.name;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    // setter methods


    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                '}';
    }
}
