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
    public TreeNode DelinorderSucessor(TreeNode root)
    {
        root=root.right;
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;


    }
    public TreeNode del(TreeNode root , int key)
    {
        if(root==null)
        {
           return root;
        }

        if(root.val < key)
        {
            root.right=del(root.right , key);
        }
        else if(root.val > key)
        {
            root.left=del(root.left,key);
        }
        else if (root.val==key){
            if(root.right==null)
            {
                return root.left;
            }
            else if ( root.left==null)
            {
                return root.right;
            }
            else{
            TreeNode delval = DelinorderSucessor(root);
            root.val= delval.val;
            root.right=del(root.right, delval.val);

            }

        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        
        return del(root,key);
    }
}