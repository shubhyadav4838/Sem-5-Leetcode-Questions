// Last updated: 30/5/2026, 4:23:14 pm
1class Solution {
2    
3    class Node {
4        int pref, suff, ans, len;
5        boolean rightBlocked;
6
7        public Node(int pref, int suff, int ans, int len, boolean rightBlocked) {
8            this.pref = pref;
9            this.suff = suff;
10            this.ans = ans;
11            this.len = len;
12            this.rightBlocked = rightBlocked;
13        }
14    }
15
16    Node[] tree;
17
18    public List<Boolean> getResults(int[][] queries) {
19        int maxX = 0;
20        for (int[] q : queries) {
21            maxX = Math.max(maxX, q[1]);
22        }
23        
24        int n = Math.min(50005, maxX + 1); 
25        
26        tree = new Node[4 * n];
27        build(1, 1, n);
28        
29        List<Boolean> res = new ArrayList<>();
30        
31        for (int[] q : queries) {
32            if (q[0] == 1) {
33                update(1, 1, n, q[1]);
34            } else {
35                int x = q[1];
36                int sz = q[2];
37                
38                Node qNode = query(1, 1, n, 1, x);
39                
40                if (qNode != null && qNode.ans >= sz) {
41                    res.add(true);
42                } else {
43                    res.add(false);
44                }
45            }
46        }
47        return res;
48    }
49
50    private void build(int v, int tl, int tr) {
51        if (tl == tr) {
52            tree[v] = new Node(1, 1, 1, 1, false);
53            return;
54        }
55        int mid = tl + (tr - tl) / 2;
56        build(2 * v, tl, mid);
57        build(2 * v + 1, mid + 1, tr);
58        tree[v] = merge(tree[2 * v], tree[2 * v + 1]);
59    }
60
61    private void update(int v, int tl, int tr, int id) {
62        if (tl == id && tr == id) {
63            tree[v].rightBlocked = true;
64            return;
65        }
66        if (id < tl || id > tr) return;
67        
68        int mid = tl + (tr - tl) / 2;
69        update(2 * v, tl, mid, id);
70        update(2 * v + 1, mid + 1, tr, id);
71        tree[v] = merge(tree[2 * v], tree[2 * v + 1]);
72    }
73
74    private Node merge(Node l, Node r) {
75        if (l == null) return r;
76        if (r == null) return l;
77
78        Node p = new Node(0, 0, 0, 0, false);
79        p.len = l.len + r.len;
80        
81        p.rightBlocked = r.rightBlocked;
82
83        boolean canMerge = !l.rightBlocked;
84
85        if (canMerge) {
86            p.pref = l.pref + (l.pref == l.len ? r.pref : 0);
87            p.suff = r.suff + (r.suff == r.len ? l.suff : 0);
88            p.ans = Math.max(Math.max(l.ans, r.ans), l.suff + r.pref);
89        } else {
90            p.pref = l.pref;
91            p.suff = r.suff;
92            p.ans = Math.max(l.ans, r.ans);
93        }
94        
95        return p;
96    }
97    
98    private Node query(int v, int tl, int tr, int l, int r) {
99        if (l > tr || r < tl) return null;
100        
101        if (l <= tl && tr <= r) return tree[v];
102        
103        int mid = tl + (tr - tl) / 2;
104        Node leftNode = query(2 * v, tl, mid, l, r);
105        Node rightNode = query(2 * v + 1, mid + 1, tr, l, r);
106        
107        return merge(leftNode, rightNode);
108    }
109}