// Last updated: 27/8/2025, 11:16:22 pm
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

        if(root == null) return true;


        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int level = 0;


        while(!q.isEmpty()){

            int size = q.size();

            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;


            for(int i = 0; i<size; i++){

                TreeNode nn = q.poll();

                int curr = nn.val;


            if(level % 2 == 0){

                if(curr % 2 == 0 || curr <= prev) return false;

            }

            else{

                if(curr % 2 != 0 || curr >= prev) return false;

            }

            prev = curr;

            if(nn.left != null) q.offer(nn.left);

            if(nn.right != null) q.offer(nn.right);

        }

        level++;

        }

        return true;

    }

}