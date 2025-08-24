// Last updated: 24/8/2025, 10:39:30 pm
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
    int max = 0;
    public int deepestLeavesSum(TreeNode root) {
        height(root,0);
        maxsum(root,0);
        return sum;

    }
    public void maxsum(TreeNode root,int curr){
        if(root==null)return;
        if(curr==max){
            sum+=root.val;
            return;
        }
        maxsum(root.left,curr+1);
        maxsum(root.right,curr+1);
    }
    public void height(TreeNode root,int curr){
        if(root==null)return;
        if(max<curr)max = curr;
        height(root.left,curr+1);
        height(root.right,curr+1);
    }
}