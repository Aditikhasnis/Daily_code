class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        HashMap<Integer , Integer> map = new HashMap<>();
        int l=0;
        int result=0;
        int max_value=1;
        for(int r=0 ; r< nums.length ;r++)
        {
            //if key exist increase by 1 else default to 1 
            map.merge(nums[r] , 1, Integer::sum);
            //if current key is greater than k then shift the left pointer till
            // the value at the right becomes <=k
            while(l<nums.length && map.get(nums[r]) > k )
            {
                map.replace(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0)
                {
                    map.remove(nums[l]);
                }
                l++;
            }
            result = Math.max(result , r-l+1);
           
        }
        return result;
    }
}