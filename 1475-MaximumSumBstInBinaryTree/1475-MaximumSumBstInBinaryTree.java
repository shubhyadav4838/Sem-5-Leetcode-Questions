// Last updated: 27/7/2026, 11:45:35 am
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair{
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        boolean isbst = true;;
        long ans = 0;
        long sum = 0;

    }
    public static int maxSumBST(TreeNode root) {
        return (int)solve(root).ans;
    }
    public static Pair solve(TreeNode root){
        if(root==null)return new Pair();

        Pair left = solve(root.left);
        Pair right = solve(root.right);
        Pair self = new Pair();
        self.sum = left.sum + right.sum + root.val;
        boolean isbst = root.val>left.max && root.val<right.min;
        self.isbst = isbst && left.isbst && right.isbst;
        self.max = Math.max(root.val,right.max);
        self.min = Math.min(root.val,left.min);
        self.ans = Math.max(left.ans,right.ans);
        if(self.isbst){
            self.ans = Math.max(self.ans,self.sum);
        }

        return self;
    }
}