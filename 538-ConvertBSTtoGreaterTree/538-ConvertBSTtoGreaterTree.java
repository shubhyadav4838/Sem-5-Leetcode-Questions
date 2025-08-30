// Last updated: 30/8/2025, 9:35:54 pm
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
    public TreeNode convertBST(TreeNode root) {
     TreeNode dummy = root;
        int a = change(root,0);
        return dummy;
    }
    public int change(TreeNode root, int sum){
        if(root==null){
            return sum;
        }
        int a = change(root.right,sum);
        root.val +=a;
        int b = change(root.left,root.val);
        return b;
    }
    
}