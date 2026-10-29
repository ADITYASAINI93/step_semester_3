package ex1;


public class prob7 {

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Strings must have equal length");
            return;
        }

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        int total = original.length();
        double accuracy = total == 0
                          ? 100.0
                          : matched * 100.0 / total;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                          matched, total, accuracy);

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position "
                + (firstMismatch + 1) + " ('"
                + original.charAt(firstMismatch) + "' vs '"
                + typed.charAt(firstMismatch) + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
    }
}
