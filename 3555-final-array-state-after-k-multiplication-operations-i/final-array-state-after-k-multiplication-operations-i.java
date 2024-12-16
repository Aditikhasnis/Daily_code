class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        


        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{

            if(a[0]!=b[0])
            {
                return a[0]-b[0];
            }
            else
            {
                return a[1]-b[1];
            }
        });
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            q.add(new int[] {nums[i],i});
        }

        while(k-->0)
        {

            int[] unpack=q.remove();
            q.add(new int[] {unpack[0]*multiplier,unpack[1]});

        }

        int[] result = new int[n];

        for(int i=0;i<n;i++)
        {
            if(!q.isEmpty())
            {
                int[] pair= q.remove();
                // System.out.println(pair[0] + " "+ pair[1]);
                result[pair[1]]=pair[0];
            }
        }

        return result;
    }
}