class Solution {
    private int BS(int low,int flag ,int target, int[] nums)
    {
        int high = nums.length;
        if(flag==0)
        {
            while(low < high)
            {
                int mid = low + (high - low) / 2;
                int val =nums[mid];
                if(val>=target)
                {
                   high=mid;
                }
                else{
                    low = mid +1;
                }
            }
        }
        else {
            while(low < high)
            {
                int mid = low + (high - low) / 2;
                int val =nums[mid];
                if(val<=target)
                {
                   low =mid+1;
                } else  {
                    high = mid;
                }

            }


        }
        return low;


    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res =0;
        for(int i=0;i<nums.length;i++)
        {
             int minReq = lower-nums[i];
             int maxReq = upper-nums[i];

             res+=BS(i+1,1,maxReq,nums) - BS(i+1,0,minReq,nums);
        }
        return res;
    }
}