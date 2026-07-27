// Last updated: 27/7/2026, 11:46:48 am
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
    static int count = 0;
	public int minCameraCover(TreeNode root) {
        count = 0;
		int val = solve(root);
		if(val==-1){
            count++;
        }
		return count;
	}
	
	public static int solve(TreeNode root) {
		if(root==null) {
			return 0;
		}
		
		int left = solve(root.left);
		int right = solve(root.right);
		
		if(left==-1 || right==-1) {
			count++;
			return 1;
		}else if(left ==1 || right ==1) {
			return 0;
		}else{
		    return -1;

        }
	}
	
}