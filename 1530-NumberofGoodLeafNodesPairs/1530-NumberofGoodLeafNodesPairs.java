// Last updated: 23/8/2025, 11:45:34 pm
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
    int count = 0;
    int mxd = 10;
    public int countPairs(TreeNode root, int distance) {
        goodPairs(root, distance);
        return count;
    }
    private int[] goodPairs(TreeNode root, int d){
        if(root == null) return new int[mxd+1];

        if(root.left == null && root.right == null){
            int[] arr = new int[mxd+1];
            arr[1] = 1;
            return arr;
        }


        int[] left = goodPairs(root.left,d);
        int[] right = goodPairs(root.right,d);

        for(int i = 1; i <= d; i++){
            for(int j = 1; j <= d-i; j++){
                count+=left[i]*right[j];
            }
        }

        int[] arr = new int[mxd+1];
        for(int i = 1; i < mxd; i++){
            arr[i+1] = left[i] + right[i];
        }

        return arr;
    }
}