package ex1;


public class prob8 {

    static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("Signal log is empty");
            return;
        }

        char currentColor = signalLog.charAt(0);
        char longestColor = currentColor;

        int currentCount = 1;
        int longestCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char current = signalLog.charAt(i);

            if (current == currentColor) {
                currentCount++;
            } else {
                currentColor = current;
                currentCount = 1;
            }

            if (currentCount > longestCount) {
                longestCount = currentCount;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor
                           + "' repeated " + longestCount + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}
