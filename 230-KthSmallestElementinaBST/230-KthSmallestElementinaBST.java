// Last updated: 14/8/2025, 11:11:07 pm
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
    int c = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        kth(root,k);
        return ans;
    }
    public void kth(TreeNode root,int k){
        if(root==null){
            return;
        }
        kth(root.left,k);
        c++;
        if(c==k){
            ans = root.val;
        }
        kth(root.right,k);
    }
}