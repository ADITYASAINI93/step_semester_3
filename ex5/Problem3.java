/**
 * Problem 3 - Top Performer Tracker
 * Find min, max, and spread in a single pass without sorting.
 */
public class Problem3 {

    /**
     * Finds minimum, maximum, and spread (max - min) in a single pass.
     *
     * @param scores array of integer scores
     * @return formatted string "Min: <min> | Max: <max> | Spread: <spread>"
     */
    static String findMinMaxSpread(int[] scores) {
        // Initialize min and max with first element
        int min = scores[0];
        int max = scores[0];

        // Single pass through array to find both min and max
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        // Test case from problem
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Test 1: " + findMinMaxSpread(scores1));
        // Expected: Min: 33 | Max: 90 | Spread: 57

        // Test case 2 - all same
        int[] scores2 = {50, 50, 50, 50};
        System.out.println("Test 2: " + findMinMaxSpread(scores2));
        // Expected: Min: 50 | Max: 50 | Spread: 0

        // Test case 3 - ascending
        int[] scores3 = {10, 20, 30, 40, 50};
        System.out.println("Test 3: " + findMinMaxSpread(scores3));
        // Expected: Min: 10 | Max: 50 | Spread: 40

        // Test case 4 - descending
        int[] scores4 = {100, 80, 60, 40, 20};
        System.out.println("Test 4: " + findMinMaxSpread(scores4));
        // Expected: Min: 20 | Max: 100 | Spread: 80

        // Test case 5 - negative numbers
        int[] scores5 = {-10, 5, -20, 15, 0};
        System.out.println("Test 5: " + findMinMaxSpread(scores5));
        // Expected: Min: -20 | Max: 15 | Spread: 35

        // Test case 6 - two elements only
        int[] scores6 = {5, 10};
        System.out.println("Test 6: " + findMinMaxSpread(scores6));
        // Expected: Min: 5 | Max: 10 | Spread: 5
    }
}