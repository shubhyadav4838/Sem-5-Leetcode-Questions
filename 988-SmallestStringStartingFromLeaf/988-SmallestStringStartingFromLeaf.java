// Last updated: 19/8/2025, 1:39:04 am
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
    public String smallestFromLeaf(TreeNode root) {
        return small(root, "");
    }

    public String small(TreeNode root, String str) {
        if (root == null) return null;

        String ans = (char)(root.val + 97) + str;

        if (root.left == null && root.right == null) return ans;

        String left = small(root.left, ans);
        String right = small(root.right, ans);

        if (left == null) return right;
        if (right == null) return left;

        return left.compareTo(right) <= 0 ? left : right;
    }
}
