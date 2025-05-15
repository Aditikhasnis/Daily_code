class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        def dfs(dp,index,cost,n):
            if index==n:
                return 0
            if index in dp.keys():
                return dp[index]
            one_step=cost[index]+dfs(dp,index+1 ,cost,n)
            two_step=float('inf')
            if index+2 <=n:
                two_step=cost[index]+dfs(dp,index+2 , cost,n)

            dp[index]=min(one_step,two_step)
            return dp[index]
        n=len(cost)
        dp={}
        return min(dfs(dp,0,cost,n),dfs(dp,1,cost,n))
        