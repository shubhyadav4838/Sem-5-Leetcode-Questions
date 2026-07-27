// Last updated: 27/7/2026, 11:45:09 am
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
    
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        boolean[] visited = new boolean[n];
        
        minDist[0] = 0;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            
            int u = -1;
            int currentMin = Integer.MAX_VALUE;
            
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDist[j] < currentMin) {
                    currentMin = minDist[j];
                    u = j;
                }
            }
            
            visited[u] = true;
            ans += currentMin;
            
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + 
                               Math.abs(points[u][1] - points[v][1]);
                    
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }
        
        return ans;
    }
}