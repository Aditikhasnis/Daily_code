class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:

        if len(quantities)==1:
            return quantities[0]

        def canIt(mid,n):
            count=sum(math.ceil(quantity/mid) for quantity in quantities ) 
            return count<=n
        
        high=max(quantities)
        low=1



        while low<=high:

            mid=(high+low)//2
  
            if canIt(mid,n):
                high=mid-1
            
            else:
                low=mid+1
        
        return low

        