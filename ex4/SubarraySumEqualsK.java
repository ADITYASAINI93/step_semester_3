import java.util.HashMap;
import java.util.Map;

/**
 * A4. Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k, return the total number of
 * contiguous subarrays whose sum equals to k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // HashMap to store prefix sum frequencies
        // Key: prefix sum, Value: frequency of that prefix sum
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        // Initialize with prefix sum 0 having frequency 1 (empty prefix)
        prefixSumCount.put(0, 1);

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            // If there exists a prefix sum such that currentSum - prefixSum = k,
            // then the subarray between that prefix and current index sums to k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update the frequency of current prefix sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        // Test case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int result1 = solution.subarraySum(nums1, k1);
        System.out.println("Test 1: " + result1); // Expected: 2

        // Test case 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        int result2 = solution.subarraySum(nums2, k2);
        System.out.println("Test 2: " + result2); // Expected: 3
    }
}