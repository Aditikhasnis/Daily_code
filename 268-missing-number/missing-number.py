class Solution:
    def missingNumber(self, nums: List[int]) -> int:


        nums.sort()
        s=sum(nums)
        m=len(nums)
        sumi=m*(m+1)//2;
      
        return sumi-s



        