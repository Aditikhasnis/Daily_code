class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<int[]> stk = new Stack<>();
        int maxRes=0;
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(!stk.isEmpty() && stk.peek()[0]<=nums[i])
            {
               j=i;
            }
            else {
                stk.push(new int[]{nums[i],i});
            }
        }
        int n=nums.length;
        for(int i=n-1;i>0;i--)
        {
            while(!stk.isEmpty() && stk.peek()[0]<=nums[i])
            {
                maxRes= Math.max(maxRes,i-stk.pop()[1]);
            }
        }
        return maxRes;
    }
}