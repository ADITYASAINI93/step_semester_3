import java.util.Arrays;

/**
 * Problem 4 - Match Day Grid Analyzer
 * Classify matches using a helper method for row average.
 */
public class Problem4 {

    /**
     * Private helper to compute the average of a single row (match).
     *
     * @param row array of runs per over for one match
     * @return average runs per over as double
     */
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    /**
     * Classifies each match as "Power Surge" or "Normal" based on threshold.
     *
     * @param runsPerOver 2D array where each row is a match, each column is an over
     * @param threshold average runs per over threshold
     * @return formatted string with each match classification
     */
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(classification);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test case from problem
        int[][] grid1 = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println("Test 1: " + classifyMatches(grid1, 8));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal

        // Test case 2 - varying row lengths
        int[][] grid2 = {
            {6, 6, 6, 6},       // avg = 6
            {10, 10},           // avg = 10
            {4, 4, 4}           // avg = 4
        };
        System.out.println("Test 2: " + classifyMatches(grid2, 7));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal

        // Test case 3 - all power surge
        int[][] grid3 = {
            {10, 12, 14},
            {15, 15, 15},
            {20, 18}
        };
        System.out.println("Test 3: " + classifyMatches(grid3, 10));
        // Expected: Match 0: Power Surge | Match 1: Power Surge | Match 2: Power Surge

        // Test case 4 - all normal
        int[][] grid4 = {
            {1, 2, 3},
            {4, 5},
            {0, 0, 0, 0}
        };
        System.out.println("Test 4: " + classifyMatches(grid4, 5));
        // Expected: Match 0: Normal | Match 1: Normal | Match 2: Normal

        // Test case 5 - exact threshold
        int[][] grid5 = {
            {5, 5, 5},    // avg = 5
            {10, 0}       // avg = 5
        };
        System.out.println("Test 5: " + classifyMatches(grid5, 5));
        // Expected: Match 0: Power Surge | Match 1: Power Surge (>= threshold)

        // Test case 6 - empty row (edge case)
        int[][] grid6 = {
            {1, 2, 3},
            {},           // empty row, avg = 0
            {4, 5}
        };
        System.out.println("Test 6: " + classifyMatches(grid6, 2));
        // Expected: Match 0: Normal | Match 1: Normal | Match 2: Power Surge
    }
}