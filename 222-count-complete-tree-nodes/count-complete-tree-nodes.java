/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// @author Aditi  2025 june 29th 
class Solution {
    public int count_nodes(TreeNode root)
    {
        if(root==null)
        return 0;
        
        return 1 + count_nodes(root.left) + count_nodes(root.right);
    }
    public int countNodes(TreeNode root) {
        
        return count_nodes(root);

    }
}