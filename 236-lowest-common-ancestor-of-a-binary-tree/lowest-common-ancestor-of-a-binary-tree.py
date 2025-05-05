# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':


        def LCA(root,p,q):
            if root==None:
                return root
            
            if root==p:
                return root
            elif root==q:
                return root

            left_side=LCA(root.left,p,q)
            right_side=LCA(root.right,p,q)

            if left_side!=None and right_side!=None:
                return root
            
            return left_side if right_side==None else right_side
        return LCA(root,p,q)


        
        
            
            





            
        