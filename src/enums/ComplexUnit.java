package enums;

public enum ComplexUnit {
    CENTIMETER(10),
    INCH(2.3),
    FOOT(1.3),
    METER(1);

    // enums can have field
    private double value;

    // enums can have constructor

    ComplexUnit(double value) {
        this.value = value;
    }

    // enums can have method
    double convert() {
        return value;
    }
}
