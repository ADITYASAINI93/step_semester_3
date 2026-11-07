class AttendanceSheet {
    private final int maxSize;
    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxSize) {
        this.maxSize = maxSize;
        this.presentStudents = new String[maxSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (name == null || this.count >= this.maxSize) {
            return;
        }

        // Check if already present
        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equals(name)) {
                return; // Already marked present
            }
        }

        this.presentStudents[this.count] = name;
        this.count++;
    }

    public int getPresentCount() {
        return this.count;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class M5_AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate, should be ignored

        System.out.println("Present count: " + sheet.getPresentCount()); // Expected: 2
        System.out.println("Is Ben present? " + sheet.isPresent("Ben")); // Expected: true
        System.out.println("Is Chen present? " + sheet.isPresent("Chen")); // Expected: false
    }
}