// Last updated: 4/9/2025, 12:30:20 am
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode address = null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        List<Integer> ll = new ArrayList<>();
        mapdata(root,map,target.val);
        getVal(address,ll,map,k,null);
        return ll;

        
    }
    public void getVal(TreeNode root, List<Integer> ll, HashMap<Integer, TreeNode> map, int k, TreeNode prev) {
    if (root == null) return;

    if (k == 0) {
        ll.add(root.val);
        return;
    }

    if (root.left != prev) {
        getVal(root.left, ll, map, k - 1, root);
    }
    if (root.right != prev) {
        getVal(root.right, ll, map, k - 1, root);
    }
    if (map.containsKey(root.val) && map.get(root.val) != prev) {
        getVal(map.get(root.val), ll, map, k - 1, root);
    }
}


    public void mapdata(TreeNode root,HashMap<Integer,TreeNode> map,int target ){
        if(root==null)return;
        if(root.val==target)address = root;
        if(root.left!=null){
            map.put(root.left.val,root);
        }
        if(root.right!=null){
            map.put(root.right.val,root);
        }
        mapdata(root.left,map,target);
        mapdata(root.right,map,target);
    }
}