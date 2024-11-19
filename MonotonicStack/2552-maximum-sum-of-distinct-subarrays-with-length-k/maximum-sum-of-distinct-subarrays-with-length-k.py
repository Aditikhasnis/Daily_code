class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:

        n=len(nums)
        l=0
        vis=set()
        maximum=0
        sumi=0
        for r in range(n):
            
            while nums[r] in vis:
                vis.remove(nums[l])
                sumi-=nums[l]
                l+=1
            vis.add(nums[r])
            sumi+=nums[r]
            # print(f'{l}{r}{vis}')
            if (r-l+1)==k:
                maximum=max(maximum,sumi)
                sumi-=nums[l]
                vis.remove(nums[l])
                l+=1
            # print(f'{l}{r}{vis}')
            # print(f'{vis} {nums[r]} {l}')

        
        return maximum

            

            

        

        