class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long result = 0;
        int l = 0;
        long sum=0;
        for (int r = 0; r < nums.length; r++) {
            map.merge(nums[r], 1, Integer::sum);
            sum+=nums[r];
           while (map.get(nums[r]) > 1) {
               map.replace(nums[l], map.get(nums[l]) - 1);
               sum-=nums[l];
               if(map.get(nums[l])==0)
               {
                   map.remove(nums[l]);
               }
               l++;
           }
            if ((r-l+1)== k) {
                result=Math.max(result,sum);
                map.replace(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l])==0)
                {
                    map.remove(nums[l]);
                }
                sum-=nums[l];
                l++;
            }

        }
        return result;

        
    }
}