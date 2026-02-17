class Solution {
    public boolean windowHasMax(int max , HashMap<Integer,Integer> map , int freq)
    {
        if(map.containsKey(max) && map.get(max)>=freq)
        {
            return true;
        }
        return false;
    }
    public long countSubarrays(int[] nums, int k) {
        int j=0;
        int maxi = Arrays.stream(nums).max().getAsInt();
        HashMap<Integer,Integer> _map = new HashMap<>();
        long count=0;
        for(int i=0;i<nums.length;i++)
        {
            _map.put(nums[i],_map.getOrDefault(nums[i],0)+1);
            while(windowHasMax(maxi,_map,k))
            { count+=nums.length-i;
              _map.replace(nums[j],_map.get(nums[j])-1);
                if(_map.get(nums[j])==0)
                {
                    _map.remove(nums[j]);
                }
                j++;
                
            }

        }

        return count;
        
    }
}