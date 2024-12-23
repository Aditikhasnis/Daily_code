# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:

        q=deque()
        q.append(root)
        count=0
        while q:
            n=len(q)
            arr_level=[]
            for _ in range(n):
                curr=q.popleft()
                arr_level.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
 
            sort_t = sorted(arr_level)
            maps = {v: i for i, v in enumerate(sort_t)}
            vis = set()

            for i in range(len(arr_level)):
                while arr_level[i]!=sort_t[i]:
                    count+=1
                    id=maps[arr_level[i]]
                    temp=arr_level[i]
                    arr_level[i]=arr_level[id]
                    arr_level[id]=temp

        return count


                    




            
                
            
                
            


            






        