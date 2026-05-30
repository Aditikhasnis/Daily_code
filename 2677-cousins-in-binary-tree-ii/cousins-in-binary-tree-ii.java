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
    public List<Integer> bfs(TreeNode root)
  {
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      List<Integer> list = new ArrayList<>();
      while(!q.isEmpty()) {
          int n = q.size();
          int sum=0;
          for (int i = 0; i < n; i++) {
              TreeNode curr = q.remove();
              if (curr.left != null) {
                  sum += curr.left.val;
                  q.add(curr.left);
              }
              if (curr.right != null) {
                  sum += curr.right.val;
                  q.add(curr.right);
              }
          }
          list.add(sum);
      }
      return list;
  }
    public  TreeNode cousinBfs(TreeNode root ,List<Integer> levelSum)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val=0;
        int level=0;
        while(!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.remove();
                int sum=0;
                boolean skip = false;
                if (curr.left != null) {
                    q.add(curr.left);
                    if(n==1) {
                        curr.left.val = 0;
                        skip=true;
                    }
                    else{
                        sum+=curr.left.val;
                    }
                    
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    if(n==1) {
                        curr.right.val = 0;
                        skip=true;
                    }
                    else{
                        sum+=curr.right.val;
                    }
                }
                if(level<levelSum.size() && !skip) {
                    int cousinVal = levelSum.get(level)-sum;
                    if(curr.left!=null)
                    {
                        curr.left.val=cousinVal;
                    }
                    if(curr.right!=null)
                    {
                        curr.right.val=cousinVal;
                    }
                }
            }
            level++;
        }
        return root;
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        return cousinBfs(root,bfs(root));
    }
}