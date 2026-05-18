// Last updated: 18/5/2026, 11:26:28 pm
1class Solution {
2    public int minJumps(int[] arr) {
3        int n = arr.length;
4        if (n == 1) return 0;
5
6        Map<Integer, List<Integer>> mp = new HashMap<>();
7        for (int i = 0; i < n; i++) {
8            mp.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
9        }
10
11        Queue<int[]> q = new LinkedList<>();
12        q.offer(new int[]{0, 0});
13
14        boolean[] vis = new boolean[n];
15        vis[0] = true;
16
17        while (!q.isEmpty()) {
18            int[] curr = q.poll();
19            int node = curr[0];
20            int dist = curr[1];
21
22            if (node == n - 1) return dist;
23
24            if (node - 1 >= 0 && !vis[node - 1]) {
25                vis[node - 1] = true;
26                q.offer(new int[]{node - 1, dist + 1});
27            }
28
29            if (node + 1 < n && !vis[node + 1]) {
30                vis[node + 1] = true;
31                q.offer(new int[]{node + 1, dist + 1});
32            }
33
34            for (int next : mp.get(arr[node])) {
35                if (!vis[next]) {
36                    vis[next] = true;
37                    q.offer(new int[]{next, dist + 1});
38                }
39            }
40
41            mp.get(arr[node]).clear();
42        }
43
44        return -1;
45    }
46}