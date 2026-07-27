// Last updated: 27/7/2026, 11:46:50 am


class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean seenNull = false;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    return false;
                }
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true;
    }
}