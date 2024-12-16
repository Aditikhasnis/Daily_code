class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:

        i,j=0,0
        temp=0
        n=len(nums)
        mini=0
        while j<n:

            if nums[j]==0:
                temp+=1

            while temp>k:
                if nums[i]==0:
                    temp-=1
                i+=1



            
            mini=max(mini,j-i+1)
            # print(f'{i}-->{j}->{mini}')
            j+=1


        return mini
            
            
            
    
        






        