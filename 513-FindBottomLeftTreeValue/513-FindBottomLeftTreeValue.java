// Last updated: 4/8/2025, 11:55:59 pm
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
    static int maxh = 0;
    public int findBottomLeftValue(TreeNode root) {
        maxh = 0;
        return find(root,1,0);
        
    }
    public int find(TreeNode root, int h, int ans){
        if(root==null)return ans;
        if(maxh<h)maxh=h;
        if(h==maxh){
            ans = root.val;
            
        }
        ans = find(root.right,h+1,ans);
        ans = find(root.left,h+1,ans);
        return ans;
    }
}