// Last updated: 16/8/2025, 12:36:34 am
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
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        countPath(root,targetSum);
        return ans;
        
    }
    public int countPath(TreeNode root,int target){
        if(root == null){
            return 0;
        }
        sum(root,0,target);
        countPath(root.left,target);
        countPath(root.right,target);
        return 0;
    }
    public void sum(TreeNode root,long curr, int target){
        if(root==null){
            return ;
        }
        if(curr+root.val==(long)(target)){
            // System.out.print("Answer Updated");
            ans++;
        }
        // if(curr>target)return;
        sum(root.left,curr+root.val,target);
        sum(root.right,curr+root.val,target);
        return;
       
    }
}