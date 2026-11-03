/**
 * A2. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current subarray or start fresh
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();

        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println("Test 1: " + result1); // Expected: 6 (subarray [4, -1, 2, 1])

        // Test case 2
        int[] nums2 = {-3, -1, -2};
        int result2 = solution.maxSubArray(nums2);
        System.out.println("Test 2: " + result2); // Expected: -1
    }
}