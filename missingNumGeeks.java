// You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive). 
// This array represents a permutation of the integers from 1 to n with one element missing. Your task is to identify and return the missing element.



class Solution {
    // Method to find the missing number from 1 to n
    public int missingNum(int[] arr, int n) {
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        return (int)(expectedSum - actualSum);
    }
}

public class Geeks {
    public static void main(String[] args) {
        // Example: n = 5, input array = {1, 2, 4, 5}, missing = 3
        int n = 5;
        int[] arr = {1, 2, 4, 5};

        Solution sol = new Solution();
        int missing = sol.missingNum(arr, n);
        System.out.println(missing);
    }
}
