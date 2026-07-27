// Last updated: 27/7/2026, 11:43:41 am
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        int[][] safeness = new int[n][n];
        for (int[] row : safeness) {
            Arrays.fill(row, -1); 
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                    safeness[i][j] = 0;
                }
            }
        }
        
        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {1, -1, 0, 0};
        
       
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];
                
               
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] == -1) {
                    safeness[nr][nc] = safeness[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        int lo = 0;
        int hi = n * 2; 
        int ans = 0;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(safeness, mid, n)) {
                ans = mid;
                lo = mid + 1; 
            } else {
                hi = mid - 1; 
            }
        }
        
        return ans;
    }
    
    private boolean isPossible(int[][] safeness, int mid, int n) {
        if (safeness[0][0] < mid || safeness[n - 1][n - 1] < mid) {
            return false;
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n]; 
        
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        
        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {1, -1, 0, 0};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            if (r == n - 1 && c == n - 1) {
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && safeness[nr][nc] >= mid) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        return false;
    }
}