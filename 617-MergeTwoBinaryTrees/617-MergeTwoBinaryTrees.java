// Last updated: 19/8/2025, 12:05:02 am
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
       return nyaTree(root1,root2);
    }
    public TreeNode nyaTree(TreeNode root1, TreeNode root2){
        TreeNode nyaNode =null;
        if(root1==null && root2 == null) return nyaNode;
        if(root1==null){
            nyaNode = new TreeNode(root2.val);
            nyaNode.left=nyaTree(null,root2.left);
            nyaNode.right = nyaTree(null,root2.right);
        }else if (root2==null){
            nyaNode = new TreeNode(root1.val);
            nyaNode.left=nyaTree(root1.left,null);
            nyaNode.right = nyaTree(root1.right,null);

        }else{
            nyaNode = new TreeNode(root1.val+root2.val);
            nyaNode.left=nyaTree(root1.left,root2.left);
            nyaNode.right = nyaTree(root1.right,root2.right);
        }
        return nyaNode;
    }
}