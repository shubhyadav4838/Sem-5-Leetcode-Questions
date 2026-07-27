// Last updated: 27/7/2026, 11:45:36 am
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
    long totalSum = 0;
    long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        totalSum = 0;
        maxProduct = 0;
        totalSum = getSum(root);
        
        getSumAndCheck(root);
        
        return (int)(maxProduct % 1_000_000_007);
    }

    public long getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    public long getSumAndCheck(TreeNode root) {
        if (root == null) return 0;

        long leftSum = getSumAndCheck(root.left);
        long rightSum = getSumAndCheck(root.right);
        
        long currentSubtreeSum = leftSum + rightSum + root.val;
        long remainingSum = totalSum - currentSubtreeSum;
        
        maxProduct = Math.max(maxProduct, currentSubtreeSum * remainingSum);
        return currentSubtreeSum;
    }
}