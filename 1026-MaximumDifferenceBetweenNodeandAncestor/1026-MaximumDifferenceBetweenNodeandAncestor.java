// Last updated: 21/8/2025, 12:23:24 am
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
    int ans = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        difference(root,root.val,root.val);
        return ans;
        
    }
    public void difference(TreeNode root,int max,int min){
        if(root==null)return;
        int a = root.val-max;
        int b = root.val-min;
        ans = Math.max(ans,Math.max(Math.abs(a),Math.abs(b)));
        difference(root.left,Math.max(max,root.val),Math.min(min,root.val));
        difference(root.right,Math.max(max,root.val),Math.min(min,root.val));
    }
}