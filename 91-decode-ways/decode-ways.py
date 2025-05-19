class Solution:
    def numDecodings(self, s: str) -> int:

        def dfs(dp,index,n,s):
            if  index>=n:
                return 1
            if s[index]=="0":
                return 0
            if index in dp:
                return dp[index]
            left =dfs(dp,index+1,n,s)
            right=0
            if index+1 < n :
                if (s[index]=="2" and s[index+1] in "0123456") or s[index]=="1":
                    right=dfs(dp,index+2,n,s)
            dp[index]=left + right
            return dp[index]
        dp={}
        return dfs(dp,0,len(s),s)