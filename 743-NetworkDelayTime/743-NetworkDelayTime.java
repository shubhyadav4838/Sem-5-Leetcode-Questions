// Last updated: 12/1/2026, 2:06:49 pm
1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        // 1. Build Graph using Adjacency List (Array of Lists)
4        // graph[i] contains list of {neighbor, weight}
5        List<int[]>[] graph = new ArrayList[n + 1];
6        for (int i = 1; i <= n; i++) {
7            graph[i] = new ArrayList<>();
8        }
9        for (int[] edge : times) {
10            graph[edge[0]].add(new int[]{edge[1], edge[2]});
11        }
12
13        // 2. Distance Array (Replacement for Visited Set)
14        int[] dist = new int[n + 1];
15        Arrays.fill(dist, Integer.MAX_VALUE);
16        dist[k] = 0; // Distance to source is 0
17
18        // 3. Priority Queue: Stores {node, cost_to_reach_node}
19        // Min-Heap based on cost
20        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
21        pq.add(new int[]{k, 0});
22
23        while (!pq.isEmpty()) {
24            int[] curr = pq.poll();
25            int u = curr[0];
26            int d = curr[1];
27
28            // OPTIMIZATION: If we found a shorter path to 'u' already, skip this stale entry
29            if (d > dist[u]) continue;
30
31            // Explore neighbors
32            for (int[] edge : graph[u]) {
33                int v = edge[0];
34                int w = edge[1];
35
36                // RELAXATION: Only push if we found a strictly better path
37                if (dist[u] + w < dist[v]) {
38                    dist[v] = dist[u] + w;
39                    pq.add(new int[]{v, dist[v]});
40                }
41            }
42        }
43
44        // 4. Find the max distance in the array
45        int maxWait = 0;
46        for (int i = 1; i <= n; i++) {
47            if (dist[i] == Integer.MAX_VALUE) return -1; // Unreachable node
48            maxWait = Math.max(maxWait, dist[i]);
49        }
50
51        return maxWait;
52    }
53}