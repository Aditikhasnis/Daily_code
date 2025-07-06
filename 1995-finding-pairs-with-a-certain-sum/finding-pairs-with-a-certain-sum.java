class FindSumPairs {
    int[] nums1 ;
    int[] nums2;
     HashMap<Integer, Integer> _map ;
    public FindSumPairs(int[] nums1, int[] nums2) {
       this.nums1=nums1;
       this.nums2=nums2;
       this._map= new HashMap<>();
       for(int a : nums2)
       {
        _map.put(a, _map.getOrDefault(a,0)+1);
       }
        
    }
    
    public void add(int index, int val) {
        int _rm=nums2[index];
        if(_map.containsKey(_rm))
        {
            int freq = _map.get(_rm);
            if (freq-1>0)
            {
                _map.put(_rm,freq-1);
            }
            else{
                _map.remove(_rm);
            }

        }
        nums2[index]+=val;
        _map.put(nums2[index], _map.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int result=0;
        for(int i=0;i<nums1.length;i++)
        {
            if(_map.containsKey(tot-nums1[i]))
            {
                result+=_map.get(tot-nums1[i]);
            }
        }
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */