class Solution {
    public int minSubArrayLen(int target, int[] nums) {
                
        int left=0 , j=0;
        int n=nums.length;     
        int res=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++)
        {

            sum+=nums[i];

            while(sum>=target)
            {
                res=Math.min(res,i-j+1);
                sum-=nums[j];
                j++;
            }
        }

        return res==Integer.MAX_VALUE?0:res;
    }
}