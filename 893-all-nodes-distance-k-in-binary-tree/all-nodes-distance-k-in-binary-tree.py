# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        graph=defaultdict(list)

        queue=deque()
        queue.append(root)

        while queue:
            
            rooti=queue.popleft()

            if rooti.left:
                graph[rooti].append(rooti.left)
                graph[rooti.left].append(rooti)
                queue.append(rooti.left)
            if rooti.right:
                graph[rooti].append(rooti.right)
                graph[rooti.right].append(rooti)
                queue.append(rooti.right)

        queue=deque()
        queue.append([target,0])
        res=[]
        vis=set()
        while queue:
            node , distance =queue.popleft()
            vis.add(node)
            if distance==k:
                res.append(node.val)
            else:
                for neighbour in graph[node]:
                    if neighbour not in vis:
                        queue.append([neighbour,distance+1])
        if not k:
            return [target.val]
        
        return res



        