// Last updated: 3/9/2025, 11:52:23 pm
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
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        ans2.add(-1);
        return isSame(root, voyage, ans1)?ans1:ans2;
    }
    public boolean isSame(TreeNode root, int[] v, List<Integer> ans){
        if(root==null) return true;
        if(root.val != v[i++]) return false;
        if(root.left != null && root.left.val != v[i]){
            ans.add(root.val);
            return isSame(root.right, v, ans) && isSame(root.left, v, ans);
        }else
            return isSame(root.left, v, ans) && isSame(root.right, v, ans);
    }
}