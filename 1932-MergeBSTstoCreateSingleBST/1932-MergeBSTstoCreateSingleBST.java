// Last updated: 1/9/2025, 11:27:18 pm
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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        palindrome(root,arr);
        return ans;
        
    }
    public void palindrome(TreeNode root, int[] arr){
        if(root==null)return;

        if(root.left==null && root.right==null){
            int count = 0;
            arr[root.val]++;
            boolean res = true;
            for(int i=0;i<arr.length;i++){
                if(arr[i]%2!=0)count++;
                if(count>1){
                    // System.out.print("INIT  ");
                    res = false;
                }
            }
            if(res)ans++;
            arr[root.val]--;
            return;
        }

        arr[root.val]++;
        palindrome(root.left,arr);
        palindrome(root.right,arr);
        arr[root.val]--;



    }
}