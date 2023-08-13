package collections.maps;

//  A TreeMap is a Map implementation in Java that maintains its entries in ascending order, sorted according to the keys' natural ordering
//  or according to a Comparator provided at the time of the TreeMap's creation.

//  TreeMap has the following characteristics:
//     - It is a sorted map, meaning that the keys are ordered according to their natural ordering or a specified Comparator.
//     - It does not allow null keys, but it does allow null values.
//     - It provides efficient access to the entries based on their keys, as well as efficient range queries (queries for a range of keys).


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapIntro {
    public static void main(String[] args) {
        System.out.println("================== TreeMap with default Comparator (natural ordering) ===============");
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2,200);
        treeMap.put(4,400);
        treeMap.put(1,100);
        treeMap.put(3,300);
        // Null keys are not allowed in TreeMap
        // treeMap.put(null, 100); // Throws NullPointerException (NPE)

        System.out.println(treeMap);


        System.out.println("================== TreeMap with built-in Comparator ===============");
        treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.put(2,200);
        treeMap.put(4,400);
        treeMap.put(1,100);
        treeMap.put(3,300);

        System.out.println(treeMap);

        System.out.println("================== TreeMap with custom Comparator ===============");
        Map<String, Integer> mapForSorting = new HashMap<>();

        // add some key-value pairs(entry) to the map
        mapForSorting.put("banana", 78);
        mapForSorting.put("apple", 85);
        mapForSorting.put("cherry", 11);

        // print the map (unsorted)
        System.out.println("unsorted map: "+ mapForSorting);


        Map<String, Integer> sortedMap = new TreeMap<>(new ValueComparator(mapForSorting));
        sortedMap.putAll(mapForSorting);
        System.out.println("sorted map: "+ sortedMap);


    }
}

// A comparator that compares the values of the map and not the keys anymore!
class ValueComparator implements Comparator<String> {

    Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }

    // returned int result:
    // 0 --> two objects are equal
    // + --> key1 is greater than key2
    // - --> key1 is smaller than key2
    @Override
    public int compare(String key1, String key2) {
        int value1 = map.get(key1);
        int value2 = map.get(key2);
        return value1 - value2;
    }

}