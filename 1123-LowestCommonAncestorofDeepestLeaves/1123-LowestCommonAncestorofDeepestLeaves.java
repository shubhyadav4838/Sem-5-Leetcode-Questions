// Last updated: 20/8/2025, 1:22:07 am
class Solution {
    int max = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        max = 0;
        calcMax(root, 1);          
        return deep(root, 1);     
    }

    private void calcMax(TreeNode node, int curr) {
        if (node == null) return;
        if (curr > max) max = curr;
        calcMax(node.left, curr + 1);
        calcMax(node.right, curr + 1);
    }

    public TreeNode deep(TreeNode root, int curr) {
        if (root == null) return null;

        if (curr == max) return root;  

        TreeNode left = deep(root.left, curr + 1);
        TreeNode right = deep(root.right, curr + 1);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;   
    }
}
