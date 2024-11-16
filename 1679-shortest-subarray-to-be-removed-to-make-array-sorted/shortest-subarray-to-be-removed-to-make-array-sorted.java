class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Step 1: Find the prefix of non-decreasing elements
        int i = 0;
        while (i < n - 1 && arr[i] <= arr[i + 1]) {
            i++;
        }

        // If the whole array is already sorted
        if (i == n - 1) {
            return 0;
        }

        // Step 2: Find the suffix of non-decreasing elements
        int j = n - 1;
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }

        // Step 3: Initialize the minimum removal to cover all cases
        int result = Math.min(n - i - 1, j); // Remove all after prefix or before suffix

        // Step 4: Merge prefix and suffix to minimize middle section removal
        int left = 0, right = j;
        while (left <= i && right < n) {
            if (arr[left] <= arr[right]) {
                result = Math.min(result, right - left - 1);
                left++;
            } else {
                right++;
            }
        }

        return result;
    }
}