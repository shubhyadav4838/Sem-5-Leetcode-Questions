// Last updated: 13/2/2026, 12:32:43 am
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
17    static class Pair{
18        long min = Integer.MAX_VALUE;
19        long max = Integer.MIN_VALUE;
20        boolean isbst = true;;
21        long ans = 0;
22        long sum = 0;
23
24    }
25    public static int maxSumBST(TreeNode root) {
26        return (int)solve(root).ans;
27    }
28    public static Pair solve(TreeNode root){
29        if(root==null)return new Pair();
30
31        Pair left = solve(root.left);
32        Pair right = solve(root.right);
33        Pair self = new Pair();
34        self.sum = left.sum + right.sum + root.val;
35        boolean isbst = root.val>left.max && root.val<right.min;
36        self.isbst = isbst && left.isbst && right.isbst;
37        self.max = Math.max(root.val,right.max);
38        self.min = Math.min(root.val,left.min);
39        self.ans = Math.max(left.ans,right.ans);
40        if(self.isbst){
41            self.ans = Math.max(self.ans,self.sum);
42        }
43
44        return self;
45    }
46}