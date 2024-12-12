class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:


        heap=[]

        for i in gifts:
            heapq.heappush(heap,-i)
        
        var=0
        while heap and k:
            curr=heapq.heappop(heap)
            var=math.floor(math.sqrt(-1*curr))
            heapq.heappush(heap,-1*var)
            k-=1
        
        return -1*(sum(heap))







        