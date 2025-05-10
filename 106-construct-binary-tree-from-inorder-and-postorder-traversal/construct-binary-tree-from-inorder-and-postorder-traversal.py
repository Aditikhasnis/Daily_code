# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:             
        _inorderMap={v:i for i,v in enumerate(inorder)}
        n=len(postorder)
        def rec(left,right):
            if left >right:
                return None
            root=TreeNode(postorder.pop())
            _rootIdx=_inorderMap[root.val]
            root.right=rec(_rootIdx+1,right)
            root.left=rec(left,_rootIdx-1)
            return root
        return rec(0,n-1)


            


        



        



        