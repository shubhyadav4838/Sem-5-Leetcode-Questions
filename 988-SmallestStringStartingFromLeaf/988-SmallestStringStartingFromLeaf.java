// Last updated: 19/8/2025, 1:40:30 am
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
        return small(root, new StringBuilder()).toString();
    }

    public StringBuilder small(TreeNode root, StringBuilder suffix) {
        if (root == null) return null;

        StringBuilder ans = new StringBuilder(suffix);
        ans.insert(0, (char)(root.val + 97));

        if (root.left == null && root.right == null) return ans;

        StringBuilder left = small(root.left, ans);
        StringBuilder right = small(root.right, ans);

        if (left == null) return right;
        if (right == null) return left;

        return left.toString().compareTo(right.toString()) <= 0 ? left : right;
    }
}
