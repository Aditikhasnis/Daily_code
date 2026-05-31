class Solution {
    public int binarySearchHigh(int high , int low , int target , int[] nums)
    {
        while(low<=high) {
            int mid = (high-low)/2 + low;
            if (target == nums[mid]) {
                if(mid+1<nums.length && nums[mid]==nums[mid+1]){
                   low =low +1;
                }
                else {
                    return mid;
                }
            }
            else if(target > nums[mid]) {
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }
        return -1;
    }

    public int binarySearchLow(int high , int low , int target , int[] nums)
    {
        while(low<=high) {
            int mid = (high-low)/2 + low;
            if (nums[mid]==target) {
                if(mid-1>=0&& nums[mid]==nums[mid-1]){
                   low =low-1;
                }
                else {
                    return mid;
                }
            }
            else if(target > nums[mid]) {
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
      int[] ans = new int[2];
      ans[1] = binarySearchHigh(nums.length-1,0,target,nums);
      if(ans[1]!=-1) {
          ans[1]=binarySearchHigh(nums.length-1,ans[1],target,nums );
          ans[0] = binarySearchLow(ans[1],0,target,nums);
          return ans;
      }

      return new int[]{-1,-1};
    }
}