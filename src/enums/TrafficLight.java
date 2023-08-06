package enums;

public enum TrafficLight {
    RED("Stop"),
    GREEN("Go"),
    YELLOW("Slow Down");

    private String message;

    TrafficLight(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
