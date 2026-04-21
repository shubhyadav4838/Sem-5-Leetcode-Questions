// Last updated: 21/4/2026, 4:35:40 pm
1import java.util.HashMap;
2
3class Solution {
4    static int[] parent;
5
6    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowed) {
7        int n = source.length;
8        parent = new int[n];
9        for (int i = 0; i < n; i++) {
10            parent[i] = i;
11        }
12
13        for (int i = 0; i < allowed.length; i++) {
14            union(allowed[i][0], allowed[i][1]);
15        }
16
17        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
18        for (int i = 0; i < n; i++) {
19            int root = find(i);
20            
21            map.putIfAbsent(root, new HashMap<>());
22            HashMap<Integer, Integer> temp = map.get(root);
23            
24            if (temp.containsKey(source[i])) {
25                temp.put(source[i], temp.get(source[i]) + 1);
26            } else {
27                temp.put(source[i], 1);
28            }
29        }
30
31        int ans = 0;
32        for (int i = 0; i < n; i++) {
33            int root = find(i); 
34            HashMap<Integer, Integer> temp = map.get(root);
35
36            if (temp != null && temp.containsKey(target[i]) && temp.get(target[i]) > 0) {
37                temp.put(target[i], temp.get(target[i]) - 1);
38            } else {
39                ans++;
40            }
41        }
42
43        return ans;
44    }
45
46    public static int find(int i) {
47        if (parent[i] == i) {
48            return i;
49        }
50        int curr = find(parent[i]);
51        parent[i] = curr;
52        return curr;
53    }
54
55    public static void union(int i, int j) {
56        int pi = find(i);
57        int pj = find(j);
58
59        if (pi != pj) {
60            parent[pj] = pi;
61        }
62    }
63}