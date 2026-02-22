// Last updated: 23/2/2026, 2:37:03 am
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int maxDepth(TreeNode root) {
18        return solve(root);
19    }
20    public static int solve(TreeNode root){
21        if(root==null){
22            return 0;
23        }
24        int left = solve(root.left);
25        int right = solve(root.right);
26        return Math.max(left,right)+1;
27    }
28}