class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }
}

public class M4_Locker {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        boolean success1 = l.changeCode("1234", "5678");
        System.out.println("Change with correct code: " + (success1 ? "success" : "rejected")); // Expected: success

        boolean success2 = l.changeCode("0000", "9999");
        System.out.println("Change with wrong code: " + (success2 ? "success" : "rejected")); // Expected: rejected

        boolean success3 = l.changeCode("5678", "1111");
        System.out.println("Change with correct new code: " + (success3 ? "success" : "rejected")); // Expected: success

        System.out.println("Locker number: " + l.getLockerNumber()); // Expected: 101
    }
}