class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character,Integer> bucket = new HashMap<>();
        for(Character i : tasks)
        {
           bucket.put(i,bucket.getOrDefault(i,0)+1);


        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        Queue<int[]> q = new LinkedList<>();
        for(Map.Entry<Character,Integer> mp : bucket.entrySet())
        {

            heap.add(mp.getValue());

        }
        int time=1;
        while(!q.isEmpty() || !heap.isEmpty())
        {

            if(!heap.isEmpty())
            {

                int current=heap.remove()-1;
                if(current>0)
                {
                     q.add(new int[] {current,time+n});

                }
               


            }

            if (!q.isEmpty() && q.peek()[1] == time )
            {
                int[] pair = q.remove();

                heap.add(pair[0]);
            }

            time++;

        }

        return time-1;








        
    }
}