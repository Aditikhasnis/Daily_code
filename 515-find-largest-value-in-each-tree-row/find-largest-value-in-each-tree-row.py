# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:

        q=deque()
        q.append(root)
        res=[]
        if root==None:
            return res        
        while q:
            n=len(q)
            maxi=float('-inf')
            for _ in range(n):
                curr=q.popleft()    
                maxi=max(maxi,curr.val)       
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if maxi!=(float('-inf')):
                res.append(maxi)
        
        return res
                








        