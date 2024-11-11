class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;

        if(n==1){
            return 0;
        }

        int[] newIntervals = new int[2];
        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        newIntervals[0]=intervals[0][0];
        newIntervals[1]=intervals[0][1];
        int count=0;
        
        for(int i=1;i<n;i++)
        {
            int u=intervals[i][0];
            int v=intervals[i][1];

            if(newIntervals[1]>u)
            {
                count++;

                newIntervals[1]=Math.min(v,newIntervals[1]);
                

            }
            else{
                newIntervals[1]=v;
            }
        }

        return count;


    }
}