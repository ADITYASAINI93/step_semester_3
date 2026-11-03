import java.util.Arrays;

/**
 * Practice Problem 3 - Top-3 Podium Finder
 * Find top 3 scores in a single pass without sorting.
 */
public class Practice3 {

    /**
     * Finds the top 3 scores in a single pass through the array.
     * Returns them in descending order (highest first).
     *
     * @param scores array of scores
     * @return array of 3 elements: [first, second, third] in descending order
     */
    static int[] findTopThreeScores(int[] scores) {
        // Initialize with minimum possible values
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                // New highest score - shift everything down
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                // New second highest
                third = second;
                second = score;
            } else if (score > third) {
                // New third highest
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        // Test case from problem
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Test 1: " + Arrays.toString(findTopThreeScores(scores1)));
        // Expected: [90, 90, 82]

        // Test case 2 - all unique
        int[] scores2 = {10, 20, 30, 40, 50};
        System.out.println("Test 2: " + Arrays.toString(findTopThreeScores(scores2)));
        // Expected: [50, 40, 30]

        // Test case 3 - all same
        int[] scores3 = {100, 100, 100, 100};
        System.out.println("Test 3: " + Arrays.toString(findTopThreeScores(scores3)));
        // Expected: [100, 100, 100]

        // Test case 4 - exactly 3 elements
        int[] scores4 = {5, 1, 3};
        System.out.println("Test 4: " + Arrays.toString(findTopThreeScores(scores4)));
        // Expected: [5, 3, 1]

        // Test case 5 - descending order input
        int[] scores5 = {100, 90, 80, 70, 60};
        System.out.println("Test 5: " + Arrays.toString(findTopThreeScores(scores5)));
        // Expected: [100, 90, 80]

        // Test case 6 - ascending order input
        int[] scores6 = {10, 20, 30, 40, 50};
        System.out.println("Test 6: " + Arrays.toString(findTopThreeScores(scores6)));
        // Expected: [50, 40, 30]

        // Test case 7 - with negative numbers
        int[] scores7 = {-10, -5, -20, 0, 5};
        System.out.println("Test 7: " + Arrays.toString(findTopThreeScores(scores7)));
        // Expected: [5, 0, -5]
    }
}