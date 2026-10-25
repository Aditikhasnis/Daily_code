class Solution {
    int[] dp ;
    private int dfs(int n){
        if(n<0){
            return 0;
        }
        if(n==1 || n==0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=dfs(n-1) + dfs(n-2);
        return dp[n];
    }
    public int climbStairs(int n) { 
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(n);
    }
}