package class_and_object;

public class ClassesAndObjects {
    public static void main(String[] args) {
        // Let's create two instances/objects of the class Building
        Building building1 = new Building("BL-1", 4, 2);
        Building building2 = new Building("BL-2", 5, 3);

        System.out.println("Building name: " + building1.getName());
        System.out.println("Number of floors: "  + building1.getNumberOfFloors());

        building1.setName("Fake building");

        System.out.println("Building name: " + building1.getName());

        System.out.println("==========================");

        System.out.println(building1);

    }
}
