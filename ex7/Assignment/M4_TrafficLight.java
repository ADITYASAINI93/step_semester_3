class TrafficLight {
    private final String id;
    private String currentColor;

    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = "RED";
    }

    public void next() {
        if (this.currentColor.equals("RED")) {
            this.currentColor = "GREEN";
        } else if (this.currentColor.equals("GREEN")) {
            this.currentColor = "YELLOW";
        } else if (this.currentColor.equals("YELLOW")) {
            this.currentColor = "RED";
        }
    }

    public String getColor() {
        return this.currentColor;
    }

    public String getId() {
        return this.id;
    }
}

public class M4_TrafficLight {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Initial color: " + t.getColor()); // Expected: RED

        t.next();
        System.out.println("After 1st next(): " + t.getColor()); // Expected: GREEN

        t.next();
        System.out.println("After 2nd next(): " + t.getColor()); // Expected: YELLOW

        t.next();
        System.out.println("After 3rd next(): " + t.getColor()); // Expected: RED

        t.next();
        System.out.println("After 4th next(): " + t.getColor()); // Expected: GREEN

        System.out.println("\nLight ID: " + t.getId()); // Expected: TL-9
    }
}