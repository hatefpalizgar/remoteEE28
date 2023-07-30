package composition;

/**
 * Composition is a stricter form of aggregation.
 * It occurs when the two classes you associate are mutually dependent and can't exist without each other.
 * For example, take a Car and an Engine class:
 * A Car cannot run without an Engine, while an Engine also can't function without being built into a Car.
 *
 * This type of relationship is also called PART-OF relationship.
 *
 * If one class ceases to exist, the other can't survive alone.
 */
public class Building {
    private String address;
    private Door door;
    private Parking parking;

    public Building(String address, Door door, Parking parking) {
        this.address = address;
        this.door = door;
        this.parking = parking;
    }

    // getters & setters
}
