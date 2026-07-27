// Last updated: 27/7/2026, 11:45:07 am
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
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null){
           
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int pre = level%2==0 ? Integer.MIN_VALUE:Integer.MAX_VALUE;

            for(int i = 0;i<size && !q.isEmpty();i++){
                TreeNode curr = q.poll();
                int x = curr.val;
                if(level%2==0 ){
                    if(x%2==0 || x<=pre){
                        
                        return false;
                    }    
                }else{
                    if(x%2!=0 || x>=pre){
                       
                        return false;
                    }
                }
                pre = x;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

            }
            level++;
        }
        return true;
    }
}