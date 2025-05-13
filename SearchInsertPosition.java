import java.util.Scanner;

public class SearchInsertPosition {

    // Function to find the index or insertion point
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return left; // Target not found, return insertion index
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements in the sorted array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Input sorted elements
        System.out.println("Enter " + n + " sorted, distinct integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Find index or insertion point
        int result = searchInsert(nums, target);

        // Display result
        System.out.println("Target should be at index: " + result);

        scanner.close();
    }
}
