// Last updated: 27/7/2026, 11:43:23 am
class Solution {
    
    class Node {
        int pref, suff, ans, len;
        boolean rightBlocked;

        public Node(int pref, int suff, int ans, int len, boolean rightBlocked) {
            this.pref = pref;
            this.suff = suff;
            this.ans = ans;
            this.len = len;
            this.rightBlocked = rightBlocked;
        }
    }

    Node[] tree;

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;
        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }
        
        int n = Math.min(50005, maxX + 1); 
        
        tree = new Node[4 * n];
        build(1, 1, n);
        
        List<Boolean> res = new ArrayList<>();
        
        for (int[] q : queries) {
            if (q[0] == 1) {
                update(1, 1, n, q[1]);
            } else {
                int x = q[1];
                int sz = q[2];
                
                Node qNode = query(1, 1, n, 1, x);
                
                if (qNode != null && qNode.ans >= sz) {
                    res.add(true);
                } else {
                    res.add(false);
                }
            }
        }
        return res;
    }

    private void build(int v, int tl, int tr) {
        if (tl == tr) {
            tree[v] = new Node(1, 1, 1, 1, false);
            return;
        }
        int mid = tl + (tr - tl) / 2;
        build(2 * v, tl, mid);
        build(2 * v + 1, mid + 1, tr);
        tree[v] = merge(tree[2 * v], tree[2 * v + 1]);
    }

    private void update(int v, int tl, int tr, int id) {
        if (tl == id && tr == id) {
            tree[v].rightBlocked = true;
            return;
        }
        if (id < tl || id > tr) return;
        
        int mid = tl + (tr - tl) / 2;
        update(2 * v, tl, mid, id);
        update(2 * v + 1, mid + 1, tr, id);
        tree[v] = merge(tree[2 * v], tree[2 * v + 1]);
    }

    private Node merge(Node l, Node r) {
        if (l == null) return r;
        if (r == null) return l;

        Node p = new Node(0, 0, 0, 0, false);
        p.len = l.len + r.len;
        
        p.rightBlocked = r.rightBlocked;

        boolean canMerge = !l.rightBlocked;

        if (canMerge) {
            p.pref = l.pref + (l.pref == l.len ? r.pref : 0);
            p.suff = r.suff + (r.suff == r.len ? l.suff : 0);
            p.ans = Math.max(Math.max(l.ans, r.ans), l.suff + r.pref);
        } else {
            p.pref = l.pref;
            p.suff = r.suff;
            p.ans = Math.max(l.ans, r.ans);
        }
        
        return p;
    }
    
    private Node query(int v, int tl, int tr, int l, int r) {
        if (l > tr || r < tl) return null;
        
        if (l <= tl && tr <= r) return tree[v];
        
        int mid = tl + (tr - tl) / 2;
        Node leftNode = query(2 * v, tl, mid, l, r);
        Node rightNode = query(2 * v + 1, mid + 1, tr, l, r);
        
        return merge(leftNode, rightNode);
    }
}