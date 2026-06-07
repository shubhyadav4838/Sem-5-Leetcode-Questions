// Last updated: 7/6/2026, 9:58:15 pm
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
17    public TreeNode createBinaryTree(int[][] descriptions) {
18        HashMap<Integer, TreeNode> mp = new HashMap<>();
19        HashMap<Integer, Integer> root = new HashMap<>();
20
21        for (int[] d : descriptions) {
22
23            int parent = d[0];
24            int child = d[1];
25            int isLeft = d[2];
26
27            if (!mp.containsKey(parent)) {
28                mp.put(parent, new TreeNode(parent));
29            }
30
31            if (!mp.containsKey(child)) {
32                mp.put(child, new TreeNode(child));
33            }
34
35            if (isLeft == 1) {
36                mp.get(parent).left = mp.get(child);
37            } else {
38                mp.get(parent).right = mp.get(child);
39            }
40
41            if (root.getOrDefault(parent, 0) != -1) {
42                root.put(parent, 1);
43            }
44
45            root.put(child, -1);
46        }
47
48        int rootVal = 0;
49
50        for (var entry : root.entrySet()) {
51            if (entry.getValue() == 1) {
52                rootVal = entry.getKey();
53                break;
54            }
55        }
56
57        return mp.get(rootVal);
58    }
59}