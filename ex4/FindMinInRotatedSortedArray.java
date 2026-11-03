/**
 * A5. Find Minimum in Rotated Sorted Array
 *
 * Given a sorted array of unique elements that has been rotated at an unknown pivot,
 * return the minimum element of this array.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If array is not rotated (already sorted), return first element
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right element,
            // the minimum must be in the right half (mid+1 to right)
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // If mid element is less than or equal to right element,
            // the minimum is in the left half including mid (left to mid)
            else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArray solution = new FindMinInRotatedSortedArray();

        // Test case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = solution.findMin(nums1);
        System.out.println("Test 1: " + result1); // Expected: 1

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = solution.findMin(nums2);
        System.out.println("Test 2: " + result2); // Expected: 0

        // Test case 3 (no rotation)
        int[] nums3 = {11, 13, 15, 17};
        int result3 = solution.findMin(nums3);
        System.out.println("Test 3: " + result3); // Expected: 11

        // Test case 4 (single element)
        int[] nums4 = {5};
        int result4 = solution.findMin(nums4);
        System.out.println("Test 4: " + result4); // Expected: 5
    }
}