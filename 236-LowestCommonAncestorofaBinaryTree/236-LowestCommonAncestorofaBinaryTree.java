// Last updated: 13/2/2026, 4:36:58 pm
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
12        return solve(root,p,q);
13    }
14    public static TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
15        if(root==null){
16            return null;
17        }
18        if(root.val==p.val || root.val==q.val){
19            return root;
20        }
21        TreeNode left = solve(root.left,p,q);
22        TreeNode right = solve(root.right,p,q);
23        if(left!=null && right!=null){
24            return root;
25        }else if(left==null){
26            return right;
27        }else{
28            return left;
29        }
30    }
31}