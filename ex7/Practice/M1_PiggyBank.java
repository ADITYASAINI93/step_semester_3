class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
        }
    }

    public int getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }
}

public class M1_PiggyBank {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Initial savings: " + pb.getSavings()); // Expected: 0

        pb.deposit(100);
        System.out.println("After depositing 100: " + pb.getSavings()); // Expected: 100

        pb.withdraw(30);
        System.out.println("After withdrawing 30: " + pb.getSavings()); // Expected: 70

        pb.withdraw(500);
        System.out.println("After trying to withdraw 500 (rejected): " + pb.getSavings()); // Expected: 70

        System.out.println("Piggy Bank ID: " + pb.getId()); // Expected: PB-1
    }
}