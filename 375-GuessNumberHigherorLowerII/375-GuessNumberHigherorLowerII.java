// Last updated: 8/8/2025, 11:19:58 pm
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums,0,nums.length-1);
    }
    public TreeNode CreateBST(int[] nums ,int si, int ei){
        if(si>ei)return null;
        int mid = si+(ei-si)/2;
        TreeNode root = new TreeNode();
        root.val = nums[mid];
        root.left = CreateBST(nums,si,mid-1);
        root.right = CreateBST(nums,mid+1,ei);
        return root;
    }
}