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
class Solution {
    int jumps=0;
    int result=0;
    public void dfs(TreeNode root , int k )
    {
        if(root==null)
        {
            return ;
        }
        
        dfs(root.left , k );
        jumps++;
        if(jumps == k)
        {
            result=root.val;
        }
        dfs(root.right,k);

        return ;
        

    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return result;
        
    }
}