class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:


        def solve(dp,i,n,suma,target,nums):
            if i==n:
                return 1 if suma==target else 0
            if (i,suma) in dp:
                return dp[(i,suma)]
            
            left=solve(dp,i+1,n,suma+nums[i],target,nums)
            right=solve(dp,i+1,n,suma-nums[i],target,nums)
            dp[(i,suma)]=left + right
            return dp[(i,suma)] 
        dp={}
        return solve(dp,0,len(nums),0,target,nums)

        