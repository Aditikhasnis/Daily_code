class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:

        def dfs(m,n,i,j,x,y,dp):

            if i<0 or i>=m or j<0 or j>=n:
                return 
            if dp[i][j]==2 or dp[i][j]==3:
                return
            
            dp[i][j]=0

            dfs(m,n,i+x,j+y,x,y,dp)
            
        

        dp=[[1 for _ in range(n)] for _ in range(m)]
        for i in guards:
            dp[i[0]][i[1]]=2
        for j in walls:
            dp[j[0]][j[1]]=3
        for i,j in guards:
            dfs(m,n,i+1,j,1,0,dp)
            dfs(m,n,i-1,j,-1,0,dp)
            dfs(m,n,i,j+1,0,1,dp)
            dfs(m,n,i,j-1,0,-1,dp)         
        
        return sum(cell==1 for row in dp for cell in row)





        