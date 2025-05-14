class Solution:
    def climbStairs(self, n: int) -> int:

        def rec(dp,n, index):
            if index==n:
                return 1
            if index in dp:
                return dp[index]
            step1=rec(dp,n,index+1)
            step2=0
            if index+2<=n:
                step2=rec(dp,n,index+2)

            dp[index]=step1+step2
            return dp[index]
        dp={}
        return rec(dp,n,0)
        