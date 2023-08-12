package collections.lists;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /* ============================================================================================== */
        //                                       List Interface
        /* ============================================================================================== */
        // Java List interface is a member of the Java Collections Framework.
        // List allows you to add duplicate elements.
        // List allows you to have ‘null’ elements
        // List is an ordered collection of items. (maintains the insertion order)

        // Declaring an arraylist of String objects
        List<String> list = new ArrayList<>();

        // How to add elements to a list?
        list.add("A");
        list.add("B");

        // Remove elements from a list
        list.remove("A");

        // How to get size of a list
        System.out.println(list.size());

        // How to check if a list is empty or not?
        System.out.println(list.isEmpty());

        // How to check if a list contains a specific element?
        System.out.println(list.contains("B"));

        // Remove all elements from a list
        list.clear();

        // Add multiple elements to a list
        // Version Java 11+
        list.addAll(List.of("A", "B", "C", "D", "A"));

        // Version Java 8-
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        list2.add("A");
        // list.addAll(list2);

        // How to get an element from a list
        System.out.println(list.get(1));

        // How to replace an element in a list by index?
        list.set(2, "W");  // this will replace "C" with the new value "W"

        // How to find the index of the first occurrence of an element in a list?
        System.out.println(list.indexOf("A"));

        // How to find the index of the last occurrence of an element in a list?
        System.out.println(list.lastIndexOf("A"));

        /* ============================================================================================== */
        //                               Java Array to List using Arrays class
        /* ============================================================================================== */
        // We can use Arrays class to get the view of array as list.
        // However, we won’t be able to do any structural modification to the list, it will throw java.lang.UnsupportedOperationException.
        // So the best way to convert array to list is to use for-loop for creating list by iterating over the array

        String[] vowels = {"a", "e", "i", "o", "u"};

        List<String> vowelsList = Arrays.asList(vowels);  // vowelsList is not a true list, it's a view of the array in form of a list
        System.out.println(vowelsList);


        /*
         * List is backed by array, we can't do structural modification
         * Both of the below statements will throw java.lang.UnsupportedOperationException
         */
        // vowelsList.remove("e");  // throws java.lang.UnsupportedOperationException
        // vowelsList.clear(); // throws java.lang.UnsupportedOperationException

        System.out.println(vowelsList.get(0));


        //using for-loop to copy elements from array to list, safe for modification of list
        List<String> myList = new ArrayList<>();
        for (String s : vowels) {
            myList.add(s);
        }

        myList.clear();

        /* ============================================================================================== */
        //                            Java List to array using toArray()
        /* ============================================================================================== */
        List<String> letters = new ArrayList<>();
        // add some example letters
        letters.add("A");
        letters.add("B");
        letters.add("C");

        // convert list to array
        String[] strArray = new String[letters.size()];
        letters.toArray(strArray);
        System.out.println(Arrays.toString(strArray));  // [A, B, C]


        /* ============================================================================================== */
        //                            List sort using sort()
        /* ============================================================================================== */
        List<Integer> integerList = new ArrayList<>();
        // TODO: Google 'Autoboxing', 'Unboxing', 'Casting' in Java

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(1000));
        }

        // natural sorting
        Collections.sort(integerList);
        System.out.println("sorted list: "  + integerList);


        /* ============================================================================================== */
        //                            List Iterator using iterator()
        /* ============================================================================================== */
        List<Integer> integerList2 = new ArrayList<>();
        for(int i=0; i<5; i++) integerList2.add(i);

        // Iterator is a class that can be used to iterate over a collection
        // It has:
        // next() method -> which returns the next element in the collection
        // hasNext() method -> which return true if there are more elements to be iterated over
        // remove() method -> which removes the current element from the collection

        Iterator<Integer> iterator = integerList2.iterator();

        // simple iteration
        while(iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.print(element + ", ");
        }
        System.out.println();

        // modification of list using iterator
        iterator = integerList2.iterator();
        while(iterator.hasNext()) {
            Integer element = iterator.next();
            if (element % 2 == 0) iterator.remove();
        }

        System.out.println(integerList2);


        // TODO:  There is another class called ListIterator
        // Discover what extra functionality it provides and test some of them


        /* ============================================================================================== */
        //                                       LinkedList
        /* ============================================================================================== */
        // LinkedList is a linear data structure where the elements are not stored in contiguous locations
        // and every element is a separate object with a data part and address part.
        // The elements are linked using pointers or addresses.
        // Each element is known as a node.

        // It also has a few disadvantages like the nodes cannot be accessed directly, instead we need to start from the head and follow through the link to reach a node we wish to access
        // LinkedLists are generally slower than Lists when it comes to accessing elements at a specific index, but they are faster at inserting and deleting elements in the middle of the list
        // As a rule of thumb: Use an ArrayList for storing and accessing data, and LinkedList to manipulate data.

        // LinkedLists have additional methods for manipulating the list,
        // such as addFirst() and addLast(), which allow you to insert elements at the beginning or end of the list.
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("element1", "element2", "element3"));
        System.out.println(linkedList);

        linkedList.addFirst("first item");
        linkedList.addLast("last item");

        System.out.println(linkedList);

        /* ============================================================================================== */
        //                                       Interview Questions
        /* ============================================================================================== */
        // 1. What is the difference between ArrayList and LinkedList?
        // 2. How to sort an ArrayList of objects using custom comparator?
        // 3. How to synchronize concurrent modifications to an ArrayList? (Collections.synchronizedList() and CopyOnWriteArrayList)

    }
}
