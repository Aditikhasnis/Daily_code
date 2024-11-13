class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:

        def rec(i,j,triangle,memo):
            if i>=len(triangle) or i<0:return 0
            # if j>=len(triangle[i]) or j<0: return 0
            if memo[i][j]!=-1:
                return memo[i][j]

            pick= triangle[i][j] + rec(i+1,j,triangle,memo)
            not_pick=triangle[i][j] + rec(i+1,j+1,triangle,memo)

            memo[i][j]=min(pick,not_pick)

            return memo[i][j]
            

        memo=[[-1 for _ in range(len(triangle))] for _ in range(len(triangle))]
        return rec(0,0,triangle,memo)



        
        