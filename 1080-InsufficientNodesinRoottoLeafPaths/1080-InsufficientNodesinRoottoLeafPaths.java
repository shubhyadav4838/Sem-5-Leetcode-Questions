// Last updated: 20/8/2025, 12:31:40 am
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
    
    public TreeNode helper(TreeNode root, int limit,int sum)
    {
         if(root == null)
         return null;
         sum += root.val;

         if (root.left == null && root.right == null) {
          return sum >= limit ? root : null;
          
         }
     
         root.left = helper(root.left, limit,sum);
         root.right = helper(root.right,limit,sum);
         
         if(root.left == null && root.right == null)
         {
             return null;
         }
      return root;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {

    int sum =0;
    if (root.left == null && root.right == null) {
       return sum + root.val >= limit ? root : null;
    }
        return helper(root, limit,sum);    
        
    }
}