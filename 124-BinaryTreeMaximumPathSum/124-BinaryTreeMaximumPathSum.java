// Last updated: 29/1/2026, 6:48:51 pm
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
17    public static int maxPathSum(TreeNode root) {
18        return solve(root).ans;
19    }
20	
21	public static Pair solve(TreeNode root) {
22		if(root==null) {
23			return new Pair();
24		}
25		
26		Pair left = solve(root.left);
27		Pair right = solve(root.right);
28		Pair self = new Pair();
29		
30		self.path = Math.max(root.val, root.val+ Math.max(left.path, right.path));
31        self.ans = Math.max(right.ans,left.ans);
32        
33        int ans = Math.max(self.path, root.val+left.path+right.path);
34		if(ans>self.ans) {
35			self.ans = ans;
36		}
37		
38		return self;
39		
40	}
41	
42	static class Pair{
43		int path =-999999;
44		int ans = -999999;
45	}
46
47}