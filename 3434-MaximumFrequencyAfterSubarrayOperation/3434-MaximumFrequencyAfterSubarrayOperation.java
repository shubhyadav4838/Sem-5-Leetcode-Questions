// Last updated: 10/2/2026, 12:52:24 pm
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
17    public TreeNode reverseOddLevels(TreeNode root) {
18        dfs(root.left,root.right,0);
19        return root;
20    }
21    public void dfs(TreeNode left, TreeNode right, int level){
22        if(left==null || right==null)return;
23
24        if(level%2==0){
25            int temp = left.val;
26            left.val = right.val;
27            right.val = temp;
28        }
29        dfs(left.left,right.right,level+1);
30        dfs(left.right,right.left,level+1);
31
32    }
33}