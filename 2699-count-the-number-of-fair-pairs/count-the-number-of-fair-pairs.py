class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:


        count=0
        nums.sort()

        for i in range(len(nums)):
            y=lower-nums[i]
            x=upper-nums[i]
            count+= bisect_right(nums,x,i+1)-bisect_left(nums,y,i+1)
            print(count)


            
        return count