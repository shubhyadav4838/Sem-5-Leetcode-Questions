// Last updated: 8/8/2025, 11:14:08 pm
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        findSum(root, targetSum, 0, ans, new ArrayList<>());
        return ans;
    }

    private void findSum(TreeNode root, int target, int sum,List<List<Integer>> ans, List<Integer> curr) {

        if (root == null) return;

        sum += root.val;
        curr.add(root.val);

        if (root.left == null && root.right == null && sum == target) {
            ans.add(new ArrayList<>(curr));
        }

        findSum(root.left, target, sum, ans, curr);
        findSum(root.right, target, sum, ans, curr);

        curr.remove(curr.size() - 1);
    }
}