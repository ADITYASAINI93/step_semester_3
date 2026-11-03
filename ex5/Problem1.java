import java.util.Arrays;

/**
 * Problem 1 - Fantasy Team Score Multiplier
 * Apply captain (2x) and vice-captain (1.5x) multipliers directly to the array.
 */
public class Problem1 {

    /**
     * Applies multipliers to captain and vice-captain scores directly in the array.
     * Modifies the caller's original array directly - returns nothing.
     *
     * @param playerScores array of player scores to modify
     * @param captainIndex index of captain (gets 2x multiplier)
     * @param viceCaptainIndex index of vice-captain (gets 1.5x multiplier)
     */
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Captain gets 2x multiplier
        playerScores[captainIndex] = playerScores[captainIndex] * 2.0;
        // Vice-captain gets 1.5x multiplier
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        // Test case from problem
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println("Test 1: " + Arrays.toString(scores));
        // Expected: [40.0, 110.0, 30.0, 93.0]

        // Additional test
        double[] scores2 = {100, 200, 300};
        applyMultipliers(scores2, 0, 2);
        System.out.println("Test 2: " + Arrays.toString(scores2));
        // Expected: [200.0, 200.0, 450.0]

        // Test with different order
        double[] scores3 = {10, 20, 30, 40, 50};
        applyMultipliers(scores3, 4, 0);
        System.out.println("Test 3: " + Arrays.toString(scores3));
        // Expected: [15.0, 20.0, 30.0, 40.0, 100.0]
    }
}