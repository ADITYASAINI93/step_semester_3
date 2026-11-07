class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = this.password.length();

        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class M3_PasswordChecker {
    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("Password 'abcd' strength: " + pc.getStrength()); // Expected: Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Password 'abcdefgh' strength: " + pc2.getStrength()); // Expected: Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Password 'abcdefghij' strength: " + pc3.getStrength()); // Expected: Strong

        PasswordChecker pc4 = new PasswordChecker("abcdefghijkl");
        System.out.println("Password 'abcdefghijkl' strength: " + pc4.getStrength()); // Expected: Strong
    }
}