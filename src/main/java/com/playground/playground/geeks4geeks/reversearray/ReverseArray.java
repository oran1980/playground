package com.playground.playground.geeks4geeks.reversearray;

/**
 * Reverse an array in groups of given size Difficulty Level : Easy Given an array, reverse every
 * sub-array formed by consecutive k elements.
 * 
 * Examples:
 * 
 * Input: arr = [1, 2, 3, 4, 5, 6, 7, 8, 9] k = 3 Output: [3, 2, 1, 6, 5, 4, 9, 8, 7]
 * 
 * Input: arr = [1, 2, 3, 4, 5, 6, 7, 8] k = 5 Output: [5, 4, 3, 2, 1, 8, 7, 6]
 * 
 * Input: arr = [1, 2, 3, 4, 5, 6] k = 1 Output: [1, 2, 3, 4, 5, 6]
 * 
 * Input: arr = [1, 2, 3, 4, 5, 6, 7, 8] k = 10 Output: [8, 7, 6, 5, 4, 3, 2, 1]
 * 
 * Approach: Consider every sub-array of size k starting from the beginning of the array and reverse
 * it. We need to handle some special cases. If k is not multiple of n where n is the size of the
 * array, for the last group we will have less than k elements left, we need to reverse all
 * remaining elements. If k = 1, the array should remain unchanged. If k >= n, we reverse all
 * elements present in the array.
 */
public class ReverseArray {

    static void reverse (int arr[], int n, int k) {
        for (int i = 0; i < n; i+=k) {
            int left = i;

            // handle case when k is not multiple of n
            int right = Math.min(i + k - 1, n - 1);
            int temp;

            // reverse the sub-array [left, right]
            while (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left += 1;
                right -= 1;
            }
        }
    }

    // Driver method
    public static void main (String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 4;

        int n = arr.length;

        reverse(arr, n, k);

        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
