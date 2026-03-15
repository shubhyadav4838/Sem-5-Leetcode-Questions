// Last updated: 15/3/2026, 10:33:26 pm
1class Solution {
2    public int minCostConnectPoints(int[][] points) {
3        int n = points.length;
4    
5        int[] minDist = new int[n];
6        Arrays.fill(minDist, Integer.MAX_VALUE);
7        
8        boolean[] visited = new boolean[n];
9        
10        minDist[0] = 0;
11        int ans = 0;
12        
13        for (int i = 0; i < n; i++) {
14            
15            int u = -1;
16            int currentMin = Integer.MAX_VALUE;
17            
18            for (int j = 0; j < n; j++) {
19                if (!visited[j] && minDist[j] < currentMin) {
20                    currentMin = minDist[j];
21                    u = j;
22                }
23            }
24            
25            visited[u] = true;
26            ans += currentMin;
27            
28            for (int v = 0; v < n; v++) {
29                if (!visited[v]) {
30                    int dist = Math.abs(points[u][0] - points[v][0]) + 
31                               Math.abs(points[u][1] - points[v][1]);
32                    
33                    if (dist < minDist[v]) {
34                        minDist[v] = dist;
35                    }
36                }
37            }
38        }
39        
40        return ans;
41    }
42}