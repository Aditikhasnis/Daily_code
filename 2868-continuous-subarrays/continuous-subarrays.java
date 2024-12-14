class Solution {
    public long continuousSubarrays(int[] nums) {
        int left = 0;      
        int right = 0;     
        int n = nums.length;
        int maxi = nums[0]; 
        int mini = nums[0]; 
        long result = 0;    

        while (right < n) {

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