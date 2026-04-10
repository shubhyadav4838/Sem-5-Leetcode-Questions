// Last updated: 10/4/2026, 7:10:07 pm
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
17    public int rob(TreeNode root) {
18        Pair res = solve(root);
19        return Math.max(res.ans,res.pre);
20        
21    }
22    public static Pair solve(TreeNode root){
23        if(root==null){
24            return new Pair(0,0);
25        }
26
27        Pair left = solve(root.left);
28        Pair right = solve(root.right);
29        int curr = left.pre + right.pre +root.val;
30        int pre = left.ans + right.ans;
31        int temp = Math.max(curr,pre);
32       
33        Pair self = new Pair(temp,pre);
34
35        return self;
36    }
37
38    static class Pair{
39        int ans;
40        int pre;
41        public Pair(int ans, int pre){
42            this.ans = ans;
43            this.pre = pre;
44        }
45    }
46
47}