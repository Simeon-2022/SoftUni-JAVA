package _04_Working_with_Abstraction_Exercise.trafficlights;

public enum Lights {
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private final String next;

    Lights(String next) {
        this.next = next;
    }

    public String getNext() {
        return next;
    }


}
