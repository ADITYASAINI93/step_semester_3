import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A3. 3Sum
 *
 * Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n) for sorting (or O(log n) for sorting stack space)
 */
public class ThreeSum {

    public int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // Convert List<List<Integer>> to int[][]
        int[][] result = new int[resultList.size()][3];
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> triplet = resultList.get(i);
            result[i][0] = triplet.get(0);
            result[i][1] = triplet.get(1);
            result[i][2] = triplet.get(2);
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] result1 = solution.threeSum(nums1);
        System.out.println("Test 1:");
        printResult(result1); // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test case 2
        int[] nums2 = {0, 0, 0};
        int[][] result2 = solution.threeSum(nums2);
        System.out.println("Test 2:");
        printResult(result2); // Expected: [[0, 0, 0]]
    }

    private static void printResult(int[][] result) {
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print("[");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
                if (j < result[i].length - 1) System.out.print(", ");
            }
            System.out.print("]");
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}