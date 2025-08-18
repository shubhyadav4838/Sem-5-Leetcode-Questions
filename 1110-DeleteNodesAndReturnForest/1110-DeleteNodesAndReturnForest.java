// Last updated: 19/8/2025, 12:54:46 am
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ll = new ArrayList<>();
        if(!isPresent(root.val,to_delete))ll.add(root);
        del(root,to_delete, ll);
        return ll;
    }
    public TreeNode del(TreeNode root, int[]arr, List<TreeNode> ll){
        if(root==null)return null;
        if(isPresent(root.val,arr)){
            root.val = -1;
        }
        root.left = del(root.left,arr,ll);
        root.right = del(root.right,arr,ll);
        if(root.val==-1){
            if(root.left!=null) ll.add(root.left);
            if(root.right!=null) ll.add(root.right);
            return null;
        }
        return root;

    }
    public boolean isPresent(int val,int[] arr){
        for(int i = 0;i<arr.length ;i++){
            if(val==arr[i]){
                return true;
            }
            
        }
        return false;
    }
}