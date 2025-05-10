# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
from collections import defaultdict
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:

        q=deque()
        g=defaultdict(list)
        q.append(root)
        startNode=root
        while q:
            n=len(q)
            for i in range(n):
                curr=q.popleft()
                if curr.left:
                    if curr.left.val==start:
                        startNode=curr.left
                    g[curr].append(curr.left)
                    g[curr.left].append(curr)
                    q.append(curr.left)
                if curr.right:
                    if curr.right.val==start:
                        startNode=curr.right
                    g[curr.right].append(curr)
                    g[curr].append(curr.right)
                    q.append(curr.right)
        minute=0
        q=deque()
        q.append([startNode,0])
        vis=set()
        while q:
            u , minute= q.popleft()
            vis.add(u)
            for v in g.get(u,[]):
                if v in vis:
                    continue
                q.append([v,minute+1])
                print(f"{u.val}-->{v.val} at minute {minute}")
            
            
        return minute
        




        