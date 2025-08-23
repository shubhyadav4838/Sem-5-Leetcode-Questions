// Last updated: 23/8/2025, 11:35:28 pm
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        height(root,0);
        return deepest(root,0);

        
    }
    public TreeNode deepest(TreeNode root,int curr){
        if(root==null)return null;
        if(curr==max){
            return root;
        }
        TreeNode a = deepest(root.left,curr+1);
        TreeNode b = deepest(root.right, curr+1);
        if(a==null && b==null)return null;
        if(a!=null && b!=null){
            return root;
        }else if(a!=null){
            return a;
        }else {
            return b;
        }
    }




    public void height(TreeNode root, int curr){
        if(root == null)return ;
        if(max<curr){
            max=curr;
        }
        height(root.left,curr+1);
        height(root.right,curr+1);
    }
}