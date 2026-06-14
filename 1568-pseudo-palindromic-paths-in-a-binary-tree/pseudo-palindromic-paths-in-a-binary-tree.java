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
        private int dfs(TreeNode root , HashMap<Integer,Integer> map) {
        if (root == null) {
            return 0;
        }
        map.merge(root.val, 1, Integer::sum);
        int left = dfs(root.left, map);
        if(root.left==null && root.right==null){
            int odd = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    odd++;
                }
            }
            if (odd == 1 || odd==0){
                left++;
            }
        }
        int right = dfs(root.right,map);
        if(map.containsKey(root.val)){
            map.put(root.val, map.get(root.val)-1);
            if(map.get(root.val)==0) {
                map.remove(root.val);
            }
        }
        return left+right;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root,new HashMap<>());
    }
}