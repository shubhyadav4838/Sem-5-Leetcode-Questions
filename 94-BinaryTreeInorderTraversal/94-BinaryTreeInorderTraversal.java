// Last updated: 1/3/2026, 1:03:48 am
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
17    public List<Integer> inorderTraversal(TreeNode root) {
18        List<Integer> ll = new ArrayList<>();
19        solve(root, ll);
20        return ll;
21        
22    }
23    public static void solve(TreeNode root, List<Integer> ll){
24        if(root==null){
25            return;
26        }
27        solve(root.left,ll);
28        ll.add(root.val);
29        solve(root.right,ll);
30    }
31}