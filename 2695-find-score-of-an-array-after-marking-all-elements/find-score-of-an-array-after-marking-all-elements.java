class Solution {
    public long findScore(int[] nums) {
        long res=0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> {
            if(a[0]!=b[0])
            {
                return a[0]-b[0];
            }
            else{
               return a[1]-b[1];
            }
    });
        HashSet<Integer> map = new HashSet<>();
        HashSet<Integer> valid = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            q.add(new int[] {nums[i],i});
            valid.add(i);
        }

        while (!q.isEmpty())
        {
            int[] unpack=q.remove();
            int index=unpack[1];
            int curr=unpack[0];
            
            if (!map.contains(index))
            {
                if(valid.contains(index+1))
                {
                    map.add(index+1);
                }
                if(valid.contains(index-1))
                {
                    map.add(index-1);
                }

                res += (long) curr;


            }

        }

        return res;
    }
}