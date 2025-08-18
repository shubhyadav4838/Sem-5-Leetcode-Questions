// Last updated: 18/8/2025, 11:47:43 pm
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
// Solution Code:?
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> al1=new ArrayList<>();
        List<Integer> al2=new ArrayList<>();
        inorder(root1,al1);
        inorder(root2,al2);
        List<Integer> ans=new ArrayList<>();
        int i=0, j=0;
        while(i<al1.size() && j<al2.size())
        {
            if(al1.get(i)<al2.get(j))
            {
                ans.add(al1.get(i));
                i++;
            }
            else
            {
                ans.add(al2.get(j));
                j++;
            }
        }
        while(i<al1.size())
        {
            ans.add(al1.get(i));
            i++;
        }
        while(j<al2.size())
        {
            ans.add(al2.get(j));
            j++;
        }
        return ans;
    }
    static void inorder(TreeNode root,List<Integer> al)
    {
        if(root==null) return ;
        
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    }
}