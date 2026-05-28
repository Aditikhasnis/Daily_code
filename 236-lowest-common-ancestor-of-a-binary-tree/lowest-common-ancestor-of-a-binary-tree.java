/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchq (TreeNode root , TreeNode p ,TreeNode q )
    {
        if(root==null)
        {
            return null;
        }
        if(root==p)
        {
            return root;
        }
        if(root == q)
        {
            return root;
        }
        TreeNode left =searchq(root.left ,p,q);
        TreeNode right=searchq(root.right,p,q);
        if(left!=null && right!=null)
        {
            return root;
        }
        return left==null?right:left;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     return searchq(root,p,q);
    }
}