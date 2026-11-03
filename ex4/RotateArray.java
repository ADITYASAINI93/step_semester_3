/**
 * L5. Rotate Array
 *
 * Given an integer array nums and an integer k, rotate the array to the right by k steps.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the new array
 */
public class RotateArray {

    public int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        // Reduce k to be within array bounds
        k = k % nums.length;
        if (k == 0) {
            return nums.clone();
        }

        int n = nums.length;
        int[] newArray = new int[n];

        // Place each element at its new position after rotation
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            newArray[newIndex] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] result1 = solution.rotateArray(nums1, k1);
        System.out.print("Test 1: ");
        printArray(result1); // Expected: [5, 6, 7, 1, 2, 3, 4]

        // Test case 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        int[] result2 = solution.rotateArray(nums2, k2);
        System.out.print("Test 2: ");
        printArray(result2); // Expected: [2, 1]

        // Test case 3
        int[] nums3 = {-1, -100, 3, 99};
        int k3 = 2;
        int[] result3 = solution.rotateArray(nums3, k3);
        System.out.print("Test 3: ");
        printArray(result3); // Expected: [3, 99, -1, -100]

        // Test case 4: k = 0
        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 0;
        int[] result4 = solution.rotateArray(nums4, k4);
        System.out.print("Test 4: ");
        printArray(result4); // Expected: [1, 2, 3, 4, 5]

        // Test case 5: k = length
        int[] nums5 = {1, 2, 3, 4, 5};
        int k5 = 5;
        int[] result5 = solution.rotateArray(nums5, k5);
        System.out.print("Test 5: ");
        printArray(result5); // Expected: [1, 2, 3, 4, 5]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}