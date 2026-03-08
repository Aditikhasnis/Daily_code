class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        HashMap<Integer , Integer> map = new HashMap<>();
        int l=0;
        int result=0;
        int max_value=1;
        for(int r=0 ; r< nums.length ;r++)
        {
            map.merge(nums[r] , 1, Integer::sum);
            max_value = Math.max(max_value,map.get(nums[r]));
            if(max_value>k)
            { 
               while(l<nums.length && map.get(nums[r]) > k )
               {
                 map.replace(nums[l],map.get(nums[l])-1);
                 if(map.get(nums[l])==0)
                 {
                    map.remove(nums[l]);
                 }
                 l++;
               }
               max_value=1;
            }

            result = Math.max(result , r-l+1);
           
        }
        return result;
    }
}