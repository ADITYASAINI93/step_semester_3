/**
 * A1. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer where answer[i] is the product
 * of all elements except nums[i], without using division.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) extra space (excluding output array)
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: answer[i] contains product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply by product of all elements to the right of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.print("Test 1: ");
        printArray(result1); // Expected: [24, 12, 8, 6]

        // Test case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.print("Test 2: ");
        printArray(result2); // Expected: [0, 0, 9, 0, 0]
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