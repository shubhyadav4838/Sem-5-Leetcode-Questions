// Last updated: 27/8/2025, 11:01:29 pm
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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        TreeNode dummy = root;
        ben10(root,false,false);
        return sum;
    }
    public void ben10(TreeNode root, boolean gp, boolean p){
        if(root==null) return;
        if(gp){
            System.out.print(root.val+" ");
            sum+=root.val;
        }
        ben10(root.left,p,root.val%2==0);
        ben10(root.right,p,root.val%2==0);


    }
}