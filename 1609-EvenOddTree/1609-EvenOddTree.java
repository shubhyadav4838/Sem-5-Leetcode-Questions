// Last updated: 12/2/2026, 11:30:44 pm
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
17    public boolean isEvenOddTree(TreeNode root) {
18        if(root==null){
19           
20            return true;
21        }
22        Queue<TreeNode> q = new LinkedList<>();
23        q.add(root);
24        int level = 0;
25        while(!q.isEmpty()){
26            int size = q.size();
27            int pre = level%2==0 ? Integer.MIN_VALUE:Integer.MAX_VALUE;
28
29            for(int i = 0;i<size && !q.isEmpty();i++){
30                TreeNode curr = q.poll();
31                int x = curr.val;
32                if(level%2==0 ){
33                    if(x%2==0 || x<=pre){
34                        
35                        return false;
36                    }    
37                }else{
38                    if(x%2!=0 || x>=pre){
39                       
40                        return false;
41                    }
42                }
43                pre = x;
44                if(curr.left!=null){
45                    q.add(curr.left);
46                }
47                if(curr.right!=null){
48                    q.add(curr.right);
49                }
50
51            }
52            level++;
53        }
54        return true;
55    }
56}