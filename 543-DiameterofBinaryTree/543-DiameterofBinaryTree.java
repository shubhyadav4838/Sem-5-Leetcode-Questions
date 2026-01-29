// Last updated: 29/1/2026, 6:06:02 pm
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
17    public static int diameterOfBinaryTree(TreeNode root) {
18		return solve(root).ans;
19	}
20	
21	public static Pair solve(TreeNode root) {
22		if(root==null) {
23			return new Pair();
24		}
25		
26		Pair left = solve(root.left);
27		Pair right = solve(root.right);
28		
29		Pair self = new Pair();
30		self.ht = Math.max(left.ht, right.ht)+1;
31		int ans = left.ht+right.ht;
32		self.ans = Math.max(left.ans, right.ans);
33		if(ans>self.ans) {
34			self.ans = ans;
35		}
36		return self;
37	}
38	
39	
40	
41	static class Pair{
42		int ht = 0;
43		int ans = 0;
44	}
45}