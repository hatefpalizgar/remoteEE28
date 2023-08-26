package io;

import java.io.Serializable;

public class Car implements Serializable {
    // TODO: Google > serialVersionUID in Java, what? why?
    private static final long serialVersionUID = 1L;

    // TODO: Read 'serialization' topic of Head First Java book
    private String model;
    private double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
