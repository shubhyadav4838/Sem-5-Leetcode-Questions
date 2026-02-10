// Last updated: 10/2/2026, 12:00:46 pm
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
17    long totalSum = 0;
18    long maxProduct = 0;
19
20    public int maxProduct(TreeNode root) {
21        totalSum = 0;
22        maxProduct = 0;
23        totalSum = getSum(root);
24        
25        getSumAndCheck(root);
26        
27        return (int)(maxProduct % 1_000_000_007);
28    }
29
30    public long getSum(TreeNode root) {
31        if (root == null) return 0;
32        return root.val + getSum(root.left) + getSum(root.right);
33    }
34
35    public long getSumAndCheck(TreeNode root) {
36        if (root == null) return 0;
37
38        long leftSum = getSumAndCheck(root.left);
39        long rightSum = getSumAndCheck(root.right);
40        
41        long currentSubtreeSum = leftSum + rightSum + root.val;
42        long remainingSum = totalSum - currentSubtreeSum;
43        
44        maxProduct = Math.max(maxProduct, currentSubtreeSum * remainingSum);
45        return currentSubtreeSum;
46    }
47}