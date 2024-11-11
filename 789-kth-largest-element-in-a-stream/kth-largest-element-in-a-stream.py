class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k=k
        self.heap=[]
        for i in nums:
            heapq.heappush(self.heap,i)      

    def add(self, val: int) -> int:
        heapq.heappush(self.heap,val)
        while len(self.heap)>self.k:
            heapq.heappop(self.heap)
        ans=heapq.heappop(self.heap)
        heapq.heappush(self.heap,ans)
        return ans
        
        
        


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)