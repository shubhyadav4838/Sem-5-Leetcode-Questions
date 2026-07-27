// Last updated: 27/7/2026, 11:44:58 am
import java.util.HashMap;

class Solution {
    static int[] parent;

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowed) {
        int n = source.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < allowed.length; i++) {
            union(allowed[i][0], allowed[i][1]);
        }

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            
            map.putIfAbsent(root, new HashMap<>());
            HashMap<Integer, Integer> temp = map.get(root);
            
            if (temp.containsKey(source[i])) {
                temp.put(source[i], temp.get(source[i]) + 1);
            } else {
                temp.put(source[i], 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int root = find(i); 
            HashMap<Integer, Integer> temp = map.get(root);

            if (temp != null && temp.containsKey(target[i]) && temp.get(target[i]) > 0) {
                temp.put(target[i], temp.get(target[i]) - 1);
            } else {
                ans++;
            }
        }

        return ans;
    }

    public static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        int curr = find(parent[i]);
        parent[i] = curr;
        return curr;
    }

    public static void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi != pj) {
            parent[pj] = pi;
        }
    }
}