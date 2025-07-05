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
// @author aditi 2025 >3 Saturday July 4th morning
class Solution {
    private  static int  _index=0;
    public TreeNode dfs(int[] preorder , int[] inorder , int left , int right, HashMap<Integer,Integer> map)
    {
        if(left > right || _index >=preorder.length)
        {
            return null;
        }

        int _num = preorder[_index++];
        int inorderIndex= map.get(_num);
        TreeNode root = new TreeNode(_num);
        root.left=dfs(preorder , inorder ,left , inorderIndex-1 , map);
        root.right=dfs(preorder, inorder , inorderIndex+1 , right, map);
    
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        _index=0;
        HashMap<Integer, Integer> _inorderMap = new HashMap<>();
        for(int i=0 ; i< inorder.length ;i++)
        {
          _inorderMap.put(inorder[i],i);
        }

        
        return dfs(preorder,inorder , 0 , inorder.length -1 ,_inorderMap);

        
    }
}