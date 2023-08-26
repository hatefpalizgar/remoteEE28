package io;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File myFile = new File("/Users/hatef.palizgar/Desktop/java-advanced-features-lecture/src/io/input.txt");

        // read from a file
        readFromFile(myFile);

        // write to a file
        writeToFile(myFile);

        // write(save) an object to a file
        Car car = new Car("Ford", 5000);

        // write an object to a file
        writeObjectToFile(car);


        // read an object from a file
        File objFile = new File("/Users/hatef.palizgar/Desktop/java-advanced-features-lecture/src/io/ford");
        readObjectFromFile(objFile);
    }

    private static void readFromFile(File myFile) {
//        BufferedReader reader = null;
//        try {
//            // FileReader is not that efficient in reading from a file
//            FileReader fileReader = new FileReader(myFile);
//
//            // BufferedReader wraps around FR and is more efficient
//            reader = new BufferedReader(fileReader);
//            String line;
//
//            while( (line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//               e.printStackTrace();
//            }
//        }

        // try-with-resources
        // takes care of closing all resources automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeToFile(File myFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true))) {
            // write() replaces/overwrites the file
            // writer.write("this is my first written line");
            writer.append("\nthis is my first written line");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeObjectToFile(Car car) {
        File file = new File("/Users/hatef.palizgar/Desktop/java-advanced-features-lecture/src/io/ford");
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(car);  // This will store car object in a file called 'ford'
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObjectFromFile(File objFile) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(objFile))) {
            Car receivedObject = (Car) stream.readObject();
            System.out.println(receivedObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
