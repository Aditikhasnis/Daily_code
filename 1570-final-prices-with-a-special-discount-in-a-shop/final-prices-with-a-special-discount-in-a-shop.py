class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:


        n=len(prices)
        stk=[]
        res=[i for i in prices]
        k=n-1
  
        for i in range(n-1,-1,-1):

            while stk and stk[-1]>prices[i]:
                stk.pop()
            if stk and stk[-1]<=prices[i]:
                res[k]=prices[k]-stk[-1]
        
            stk.append(prices[i])
            k-=1
  
        # for i in range(n):

        #     if res[i]!=-1:
        #         res[i]=prices[i]-res[i]
        #     else:
        #         res[i]=prices[i]

        return res



        