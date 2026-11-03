/**
 * L3. Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 *
 * Time Complexity: O(n²) - using nested loops as specified
 * Space Complexity: O(1)
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        // Using two nested loops to compare every pair
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        boolean result1 = solution.containsDuplicate(nums1);
        System.out.println("Test 1: " + result1); // Expected: true

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        boolean result2 = solution.containsDuplicate(nums2);
        System.out.println("Test 2: " + result2); // Expected: false

        // Test case 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean result3 = solution.containsDuplicate(nums3);
        System.out.println("Test 3: " + result3); // Expected: true
    }
}