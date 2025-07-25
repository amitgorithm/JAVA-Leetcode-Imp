// Given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist). If there are multiple peak elements, return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".

// Note: Consider the element before the first element and the element after the last element to be negative infinity.

class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int left = (mid == 0) ? Integer.MIN_VALUE : arr[mid - 1];
            int right = (mid == n - 1) ? Integer.MIN_VALUE : arr[mid + 1];

            if (arr[mid] > left && arr[mid] > right) {
                return mid;
            } else if (left > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // Should never be reached if input is valid
    }
}
