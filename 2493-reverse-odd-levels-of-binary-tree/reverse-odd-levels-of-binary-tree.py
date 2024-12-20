# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        q=deque()
        q.append((root,0))
        level=0
        while q:
            size=len(q)
            level=0
            curr_level=[]
            for i in range(size):
                curr,level=q.popleft()
                curr_level.append(curr)
                if curr.left:
                    q.append((curr.left,level+1))
                if curr.right:
                    q.append((curr.right,level+1))
            if level%2==1:
                left,right=0,len(curr_level)-1
                while left< right:
                    temp=curr_level[left].val
                    curr_level[left].val=curr_level[right].val
                    curr_level[right].val=temp
                    left+=1
                    right-=1
            

              

            

        
        return root

                






        