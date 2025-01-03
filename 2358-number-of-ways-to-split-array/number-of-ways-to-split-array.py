class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:

        s=sum(nums)
        valid=0
        n=len(nums)
        s1=0
        for i in range(n-1):
            s1+=nums[i]
            if s1>= (s-s1):
                valid+=1
            

        return valid 


        