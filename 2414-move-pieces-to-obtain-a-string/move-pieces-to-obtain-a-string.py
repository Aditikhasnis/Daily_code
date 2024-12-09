from collections import deque
class Solution:
    def canChange(self, start: str, target: str) -> bool:
        
        if len(start)!=len(target):
            return False
        i,j=0,0
        n=len(start)
        m=len(target)
        while i<n or j<n:
            while i<n and start[i]=='_':
                i+=1
            while j<n and target[j]=='_':
                j+=1
            if i==n or j==n:
                break
            print(f'{i} {j}')   
            if i<n and j<n and start[i]!=target[j]:           
                return False
            if i<n and j<n and start[i]=='L' and j>i:      
                return False
            if i<n and j<n and start[i]=='R' and i>j:
                return False
            i+=1
            j+=1
        
        return i==n  and j==n

            







            

            

            









        