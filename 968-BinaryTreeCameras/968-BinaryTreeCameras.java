// Last updated: 29/1/2026, 7:33:36 pm
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
17    static int count = 0;
18	public int minCameraCover(TreeNode root) {
19        count = 0;
20		int val = solve(root);
21		if(val==-1){
22            count++;
23        }
24		return count;
25	}
26	
27	public static int solve(TreeNode root) {
28		if(root==null) {
29			return 0;
30		}
31		
32		int left = solve(root.left);
33		int right = solve(root.right);
34		
35		if(left==-1 || right==-1) {
36			count++;
37			return 1;
38		}else if(left ==1 || right ==1) {
39			return 0;
40		}else{
41		    return -1;
42
43        }
44	}
45	
46}