class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        

        i,j=0,1
        n=len(nums)
        count=0
        temp=nums[0]
        res=[-1]*(n-k+1)
        m=0
        while i<=(n-k):
            temp=nums[i]
            count=1
            valid=True
            for j in range(i+1,i+k):
                if nums[j]-temp==1:
                    temp=nums[j]
                    count+=1
                else:
                    valid=False
                    break
                       
            if valid and (count==k):
                res[m]=temp
               
            else:
                res[m]=-1
            m+=1    
            i+=1

        return res


            


