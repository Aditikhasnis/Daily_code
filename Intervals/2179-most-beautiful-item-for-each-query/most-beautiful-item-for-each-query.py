class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:

        # def binary(l,r,items,x):
        #     mid=0
        #     while l<=r:
        #         mid=(l+r)//2    
        #         if items[mid][0]==x:
        #             return max(items[:mid+1],key=lambda x:x[1])[1] if mid>=0 else 0
        #         elif items[mid][0]<x:
        #             l=mid+1
        #         else:
        #             r=mid-1
          
        #     return max(items[:r+1],key=lambda x:x[1])[1] if r>=0 else 0
        
        # items=sorted(items,key=lambda x:x[0])
        # val=-1
        # fake=[]
        # vis=set()
        # for i in range(len(items)):
            
        # fake.sort(key=lambda x:x[0])
        # print(fake)
        # res=[]
        # for i in queries:
        #     res.append(binary(0,len(fake)-1,fake,i))
        
        # return res
        items.sort()
        dedup_items = []
        max_beauty = 0
        
        # Deduplicate and calculate max beauty up to each price
        for price, group in groupby(items, key=lambda x: x[0]):
            # Get the maximum beauty for this unique price
            max_beauty_for_price = max(beauty for _, beauty in group)
            max_beauty = max(max_beauty, max_beauty_for_price)
            dedup_items.append([price, max_beauty])
        
        # Step 2: Define a binary search function to find max beauty for each query
        def binary_search(x):
            l, r = 0, len(dedup_items) - 1
            while l <= r:
                mid = (l + r) // 2
                if dedup_items[mid][0] <= x:
                    l = mid + 1
                else:
                    r = mid - 1
            # If r >= 0, dedup_items[r][1] has the maximum beauty up to the highest valid price <= x
            return dedup_items[r][1] if r >= 0 else 0
        
        # Step 3: Process each query using binary search on dedup_items
        return [binary_search(query) for query in queries]


        








        