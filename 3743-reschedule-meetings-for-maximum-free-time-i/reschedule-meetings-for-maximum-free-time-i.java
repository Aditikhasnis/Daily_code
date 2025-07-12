class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int result=0;
        int n=startTime.length;
        int[] gap = new int[n+1];
        gap[0]=startTime[0];
        for(int i=1;i<startTime.length;i++)
        {
            gap[i]=startTime[i]-endTime[i-1];
        }

        gap[n]=eventTime-endTime[n-1];
        int cnt=0;

        for(int i=0;i<=k;i++)
        {
            cnt+=gap[i];
        }
        int maxi=-1;

        maxi=Math.max(maxi,cnt);

        for(int i=1;i<n-k+1;i++)
        {
            cnt-=gap[i-1];
            cnt+=gap[i+k];
            maxi=Math.max(maxi,cnt);
        }

        return maxi;
    }
}