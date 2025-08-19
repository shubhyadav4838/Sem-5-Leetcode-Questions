// Last updated: 20/8/2025, 1:21:11 am
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
    int max = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxHeight(root,0);
        return deep(root,0).anc;
        
    }
    public void maxHeight(TreeNode root, int curr){
        if(root==null)return ;

        if(max<curr){
            max=curr;
        }
        maxHeight(root.left,curr+1);
        maxHeight(root.right,curr+1);

    }
    public Pair deep(TreeNode root, int curr){
        if(root==null)return new Pair();

        Pair left = deep(root.left,curr+1);
        Pair right = deep(root.right,curr+1);
        Pair self = new Pair();

        if (curr == max) {
            self.isdeep = true;
            self.anc = root;
            return self;
        }

        if (left.isdeep && right.isdeep) {
            self.isdeep = true;
            self.anc = root;
        }
        else if (left.isdeep) {
            self.isdeep = true;
            self.anc = left.anc;
        }
        else if (right.isdeep) {
            self.isdeep = true;
            self.anc = right.anc;
        }

        return self;

    }
    class Pair{
        boolean isdeep = false;
        TreeNode anc = null;

    }
    
}
