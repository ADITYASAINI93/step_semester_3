/**
 * L4. Merge Two Sorted Arrays
 *
 * Given two sorted integer arrays arr1 and arr2, merge them into a single sorted array.
 *
 * Time Complexity: O(m + n) where m and n are lengths of arr1 and arr2
 * Space Complexity: O(m + n) for the result array
 */
public class MergeTwoSortedArrays {

    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] result = new int[m + n];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result

        // Compare elements and merge
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < m) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < n) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays solution = new MergeTwoSortedArrays();

        // Test case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result1 = solution.mergeSortedArrays(arr1, arr2);
        System.out.print("Test 1: ");
        printArray(result1); // Expected: [1, 2, 3, 4, 5, 6]

        // Test case 2
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] result2 = solution.mergeSortedArrays(arr3, arr4);
        System.out.print("Test 2: ");
        printArray(result2); // Expected: [1, 2, 3]

        // Test case 3
        int[] arr5 = {1, 2, 3};
        int[] arr6 = {};
        int[] result3 = solution.mergeSortedArrays(arr5, arr6);
        System.out.print("Test 3: ");
        printArray(result3); // Expected: [1, 2, 3]

        // Test case 4
        int[] arr7 = {1, 4, 7};
        int[] arr8 = {2, 3, 5, 6, 8};
        int[] result4 = solution.mergeSortedArrays(arr7, arr8);
        System.out.print("Test 4: ");
        printArray(result4); // Expected: [1, 2, 3, 4, 5, 6, 7, 8]
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