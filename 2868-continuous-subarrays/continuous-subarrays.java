class Solution {
    public long continuousSubarrays(int[] nums) {
        int left = 0;      // Left pointer of the window
        int right = 0;     // Right pointer of the window
        int n = nums.length;
        int maxi = nums[0]; // Maximum value in the window
        int mini = nums[0]; // Minimum value in the window
        long result = 0;    // Total number of continuous subarrays

        while (right < n) {
            // Update maxi and mini for the current window
            maxi = Math.max(maxi, nums[right]);
            mini = Math.min(mini, nums[right]);
            while (maxi - mini > 2) {
 
                left++;

                mini = Integer.MAX_VALUE;
                maxi = Integer.MIN_VALUE;
                for (int i = left; i <= right; i++) {
                    mini = Math.min(mini, nums[i]);
                    maxi = Math.max(maxi, nums[i]);
                }
            }


            result += (right - left + 1);

      
            right++;
        }

        return result;
    }
}