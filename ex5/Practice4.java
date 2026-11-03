import java.util.Arrays;

/**
 * Practice Problem 4 - Hackathon Seating Grid Optimizer
 * Classify rows using a helper method for row average.
 */
public class Practice4 {

    /**
     * Private helper to compute the average of a single row.
     *
     * @param row array of scores for one row
     * @return average score as double
     */
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    /**
     * Classifies each row as "Quiet Zone" or "Buzzing Zone" based on threshold.
     *
     * @param seatingScores 2D array where each row is a seating row
     * @param threshold average score threshold
     * @return formatted string with each row classification
     */
    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String classification = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(classification);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test case from problem
        int[][] grid1 = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println("Test 1: " + classifyRows(grid1, 60));
        // Expected: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone

        // Test case 2 - varying row lengths
        int[][] grid2 = {
            {50, 50, 50, 50},   // avg = 50
            {70, 80},           // avg = 75
            {40, 40, 40}        // avg = 40
        };
        System.out.println("Test 2: " + classifyRows(grid2, 60));
        // Expected: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone

        // Test case 3 - all buzzing
        int[][] grid3 = {
            {80, 90, 100},
            {95, 95},
            {70, 80, 90, 100}
        };
        System.out.println("Test 3: " + classifyRows(grid3, 70));
        // Expected: Row 0: Buzzing Zone | Row 1: Buzzing Zone | Row 2: Buzzing Zone

        // Test case 4 - all quiet
        int[][] grid4 = {
            {10, 20, 30},
            {5, 5},
            {0, 0, 0, 0}
        };
        System.out.println("Test 4: " + classifyRows(grid4, 50));
        // Expected: Row 0: Quiet Zone | Row 1: Quiet Zone | Row 2: Quiet Zone

        // Test case 5 - exact threshold
        int[][] grid5 = {
            {60, 60, 60},   // avg = 60
            {30, 90}        // avg = 60
        };
        System.out.println("Test 5: " + classifyRows(grid5, 60));
        // Expected: Row 0: Buzzing Zone | Row 1: Buzzing Zone (>= threshold)

        // Test case 6 - empty row
        int[][] grid6 = {
            {50, 50, 50},
            {},             // empty row, avg = 0
            {70, 80}
        };
        System.out.println("Test 6: " + classifyRows(grid6, 40));
        // Expected: Row 0: Buzzing Zone | Row 1: Quiet Zone | Row 2: Buzzing Zone
    }
}