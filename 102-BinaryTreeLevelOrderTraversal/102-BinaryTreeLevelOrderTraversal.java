// Last updated: 28/2/2026, 1:52:08 am
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> ll = new ArrayList<>();
19        Queue<TreeNode> q = new LinkedList<>();
20        if(root==null)return ll;
21        q.add(root);
22        // System.out.println(root.val);
23        while(!q.isEmpty()){
24            int size = q.size();
25            List<Integer> temp = new ArrayList<>();
26            for(int i = 0;i<size && !q.isEmpty();i++){
27                TreeNode c = q.poll();
28                temp.add(c.val);
29                if(c.left!=null){
30                    q.add(c.left);
31                }
32                if(c.right!=null){
33                    q.add(c.right);
34                }
35            }
36            ll.add(temp);
37        }
38        return ll;
39        
40    }
41}