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
    public void dfs(TreeNode root , List<Integer> list)
    {
        if(root==null)
        {
            return ;
        }

        list.add(root.val);
        dfs(root.left , list);
        dfs(root.right,list);
        return ;

    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        Collections.sort(list);
        return list.get(k-1);
        
    }
}