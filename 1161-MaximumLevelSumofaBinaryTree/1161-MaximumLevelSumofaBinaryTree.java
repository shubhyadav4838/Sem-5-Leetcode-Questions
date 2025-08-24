// Last updated: 24/8/2025, 10:52:10 pm
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
    public int maxLevelSum(TreeNode root) {
        return levelOrder(root);
    }
    public int levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        int sum = root.val;
        q.add(root);
        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int cursum = 0;
            for(int i=0;i<size;i++){
                TreeNode nn = q.poll();
                cursum+=nn.val;
                if(nn.right!=null){
                    q.add(nn.right);
                }
                if(nn.left!=null){
                    q.add(nn.left);
                }
            }
            level++;
            if(cursum>sum){
                ans = level;
                sum = cursum;
            }

        }
        return ans;
    }
}