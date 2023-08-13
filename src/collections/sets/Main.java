package collections.sets;


import java.util.*;

/*
 * ==============================================================================================
 *                                      Set Interface
 * ==============================================================================================
 * Java Set interface is a member of the Java Collections Framework.
 * A set does not allow duplicate elements.
 * Order of elements is not guaranteed.
 */
public class Main {
    public static void main(String[] args) {
        Set<String> travelRoute = new HashSet<>();
        travelRoute.add("Berlin");
        travelRoute.add("Tallinn");
        travelRoute.add("Paris");
        travelRoute.add("London");
        travelRoute.add("Paris");
        travelRoute.add("Tallinn");
        travelRoute.remove("London");

        System.out.println(travelRoute);

        /* ============================================================================================== */
        //                              Union, Intersection, Difference
        /* ============================================================================================== */
        // Union: returns a new set containing all elements from both sets
        Set<Integer> setA = new HashSet<>();
        setA.addAll(Arrays.asList(1,3,2,4,8,9,0));

        Set<Integer> setB = new HashSet<>();
        setB.addAll(Arrays.asList(1,3,7,5,4,0,7,5));

        // To find Union of two sets:
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Union of the two sets: " + union);

        // Intersection: returns a new set containing all elements that are common to both sets
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection of the two sets: " + intersection);

        // Difference: returns a new set containing all elements that are in the first set but not in the second set
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference of the two sets: " + difference);

        /* ============================================================================================== */
        //                                 HashSet, EnumSet, LinkedHashSet, TreeSet
        /* ============================================================================================== */
        // 1. HashSet: do not guarantee order of elements. It is a good choice for storing elements that are not ordered.

        // 2. EnumSet: is a set of elements of a specific enum type. High-performance and faster than HashSet.
        Set<Days> enumSet = EnumSet.of(Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY);
        System.out.println(enumSet);

        // 3. LinkedHashSet: is a set that maintains the order of elements in which they were inserted.
        // When iterating through a HashSet, the order is unpredictable, while a LinkedHashSet lets us
        // iterate through the elements in the order in which they were inserted.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("India");
        linkedHashSet.add("Australia");
        linkedHashSet.add("South Africa");
        // adding a duplicate element
        linkedHashSet.add("India");

        System.out.println("linkedHashSet: " + linkedHashSet);

        linkedHashSet.remove("Australia");
        System.out.println("linkedHashSet after removing Australia: " + linkedHashSet);

        Iterator<String> iterator = linkedHashSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 4. TreeSet: it behaves like a hash set with the exception that it stores elements in a sorted format.
        // It is a good choice for storing elements that are ordered and sorted.
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("India");
        treeSet.add("Australia");
        treeSet.add("South Africa");
        // adding a duplicate element
        treeSet.add("India");

        System.out.println("TreeSet: "+treeSet);

        // To learn more: https://www.geeksforgeeks.org/set-in-java/?ref=lbp
    }
}

enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

