class Solution:
    def findScore(self, nums: List[int]) -> int:


        heap=[]
        valid_idx=set()
        new_set=set()
        for idx,i in enumerate(nums):
            heapq.heappush(heap,(i,idx))
            valid_idx.add(idx)
        res=0
        while heap:
            curr,index=heapq.heappop(heap)
            if index not in new_set:
                if index+1 in valid_idx:
                    new_set.add(index+1)
                if index-1 in valid_idx:
                    new_set.add(index-1)
                res+=curr
        return res



        
        