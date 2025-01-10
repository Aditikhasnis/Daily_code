class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:


        def counting(nums,k):

            count=0
            l,r=0,0
            n=len(nums)
            d={}
            while r<n:

                d[nums[r]]= d.get(nums[r],0)+1
                r+=1
                while len(d)>k:
                    d[nums[l]]-=1
                    if d[nums[l]]==0:
                        del d[nums[l]]
                    l+=1
                count+=(r-l+1)
            
            return count
        return counting(nums,k)-counting(nums,k-1)

        