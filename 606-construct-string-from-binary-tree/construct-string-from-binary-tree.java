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

     public String dfs(TreeNode root, StringBuilder sb ) {
        // Quick bug fix: check if root is null BEFORE accessing root.val
        if (root == null) {
            return "";
        }
    
        sb.append("(");
        sb.append(root.val);

        dfs(root.left, sb);
        if (root.left == null && root.right != null) {
            sb.append("()");
        }
        dfs(root.right, sb);

        return sb.append(")").toString();
    }
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        String res = dfs(root, sb);
        return res.substring(1,res.length()-1);
    }
}