import java.math.BigDecimal;
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
              PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for( int i =0 ;i<position.length ; i++)
        {
            pq.add(new int[]{position[i],speed[i]});
        }
        Stack<int[]> stk = new Stack<>();

        while(!pq.isEmpty())
        {
            stk.push(pq.poll());
        }
        BigDecimal fleet_group= new BigDecimal(0);
        int fleet=0;
        while(!stk.isEmpty())
        {
            int[] aee = stk.pop();
            double currentTime = (double)(target - aee[0]) / aee[1];

// Convert to BigDecimal only if you specifically need that type for storage/precision
            BigDecimal time = BigDecimal.valueOf(currentTime);

// Compare using doubleValue() as you intended
            if (fleet_group.doubleValue() == 0 || fleet_group.doubleValue() < time.doubleValue()) {
                fleet++;
                fleet_group = time;
            }

            if(fleet_group.doubleValue()==0 || fleet_group.doubleValue()<time.doubleValue())
            {
                fleet++;
                fleet_group=time;
            }

        }
        return fleet;
    }
}