class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        vis=set()
        for i in arr:
            vis.add(i)
        
        c=Counter(arr)
        
        for i in range(len(arr)):
            n=arr[i]
            if n%2==0 and n//2 in vis:
                # if i==(arr[i]//2) and c[arr[i]]>1:
                    # print(i)
                if arr[i]==(n//2) and c[arr[i]]==1:
                    continue
                else:
                    return True
        return False



        