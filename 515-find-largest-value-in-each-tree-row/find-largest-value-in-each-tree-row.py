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
        res.append(root.val)
        

        while q:

            n=len(q)
            maxi=-float('inf')
            for _ in range(n):
                curr=q.popleft()           
                if curr.left:
                    q.append(curr.left)
                    if curr.left.val>maxi:
                        maxi=curr.left.val
                if curr.right:
                    q.append(curr.right)
                    if curr.right.val>maxi:
                        maxi=curr.right.val
            if maxi!=(-float('inf')):
                res.append(maxi)
        
        print(res)
        return res
                








        