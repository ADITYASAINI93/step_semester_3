import java.util.Arrays;

/**
 * Practice Problem 1 - Hackathon Score Curve Booster
 * Boost every score in place by a flat bonus amount.
 */
public class Practice1 {

    /**
     * Adds a flat bonus to every score in the array directly.
     * Modifies the caller's original array - returns nothing.
     *
     * @param scores array of scores to boost
     * @param bonus flat bonus to add to each score
     */
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        // Test case from problem
        int[] scores1 = {70, 85, 60};
        curveScores(scores1, 10);
        System.out.println("Test 1: " + Arrays.toString(scores1));
        // Expected: [80, 95, 70]

        // Test case 2 - zero bonus
        int[] scores2 = {50, 60, 70};
        curveScores(scores2, 0);
        System.out.println("Test 2: " + Arrays.toString(scores2));
        // Expected: [50, 60, 70]

        // Test case 3 - large bonus
        int[] scores3 = {10, 20, 30};
        curveScores(scores3, 100);
        System.out.println("Test 3: " + Arrays.toString(scores3));
        // Expected: [110, 120, 130]

        // Test case 4 - empty array
        int[] scores4 = {};
        curveScores(scores4, 10);
        System.out.println("Test 4: " + Arrays.toString(scores4));
        // Expected: []

        // Test case 5 - single element
        int[] scores5 = {55};
        curveScores(scores5, 5);
        System.out.println("Test 5: " + Arrays.toString(scores5));
        // Expected: [60]
    }
}