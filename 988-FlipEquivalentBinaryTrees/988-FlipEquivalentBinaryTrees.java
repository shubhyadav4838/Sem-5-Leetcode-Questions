// Last updated: 3/8/2025, 11:56:04 pm
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
		    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		    	 if(root1==null && root2==null){
			            return true;
			        }
			        if(root1==null || root2==null){// dono mese ek null h
			            return false;
			        }
			        if(root1.val!=root2.val){
			            return false;
			        }
			        boolean flip = flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);
			        boolean noflip = flipEquiv(root1.right,root2.right) && flipEquiv(root1.left,root2.left);
			        return flip || noflip;
		    }
		}