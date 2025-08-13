// Last updated: 13/8/2025, 11:33:16 am
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
		int Camera = 0;
		public int minCameraCover(TreeNode root) {
			int c  = minCamera(root);
			if(c==-1) {
				Camera++;
			}
			return Camera;

		}

		public int minCamera(TreeNode root) {
			if(root==null)return 0;
			
			int left = minCamera(root.left);
			int right = minCamera(root.right);
			if(left==-1 || right==-1) {
				Camera++;
				return 1; 
			}
			else if(left==1 || right ==1) { 
				return 0;
			} 
			else {
				return -1; 
			}

		}

	}