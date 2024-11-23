class Solution:
    def trap(self, height: List[int]) -> int:
        
        r=[]
        n=len(height)
        maxi=height[n-1]
        if n<=2:
            return 0
        for i in range(n-1,-1,-1):
            maxi=max(maxi,height[i])
            r.append(maxi)
        r=r[::-1]
        maxi=height[0]
        l=[]
        for i in range(n):
            maxi=max(maxi,height[i])
            l.append(maxi)
  
        return sum(min(l[i],r[i])-height[i] for i in range(1,n-1) )


        



