class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        pairs.sort(key=lambda x: x[0])
      
        def dfs(dp,heap , index , n , b):
            if index>=n:
                return 0
            if (index,b) in dp:
                return dp[(index,b)]
            skip=dfs(dp,heap,index+1,n,b)
            take=0
            if b < heap[index][0] or b==float(inf):
                take=1 + dfs(dp,heap, index+1 , n ,heap[index][1])
            dp[(index,b)]=max(take,skip)
            return dp[(index,b)]
        dp={}
        return dfs(dp,pairs,0,len(pairs),float(inf))


        