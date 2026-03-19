// Last updated: 19/3/2026, 8:14:46 pm
1class Solution {
2    public int maximumSafenessFactor(List<List<Integer>> grid) {
3        int n = grid.size();
4        
5        int[][] safeness = new int[n][n];
6        for (int[] row : safeness) {
7            Arrays.fill(row, -1); 
8        }
9        
10        Queue<int[]> q = new LinkedList<>();
11        
12        for (int i = 0; i < n; i++) {
13            for (int j = 0; j < n; j++) {
14                if (grid.get(i).get(j) == 1) {
15                    q.add(new int[]{i, j});
16                    safeness[i][j] = 0;
17                }
18            }
19        }
20        
21        int[] dRow = {0, 0, -1, 1};
22        int[] dCol = {1, -1, 0, 0};
23        
24       
25        while (!q.isEmpty()) {
26            int[] curr = q.poll();
27            int r = curr[0];
28            int c = curr[1];
29            
30            for (int i = 0; i < 4; i++) {
31                int nr = r + dRow[i];
32                int nc = c + dCol[i];
33                
34               
35                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] == -1) {
36                    safeness[nr][nc] = safeness[r][c] + 1;
37                    q.add(new int[]{nr, nc});
38                }
39            }
40        }
41        
42        int lo = 0;
43        int hi = n * 2; 
44        int ans = 0;
45        
46        while (lo <= hi) {
47            int mid = lo + (hi - lo) / 2;
48            if (isPossible(safeness, mid, n)) {
49                ans = mid;
50                lo = mid + 1; 
51            } else {
52                hi = mid - 1; 
53            }
54        }
55        
56        return ans;
57    }
58    
59    private boolean isPossible(int[][] safeness, int mid, int n) {
60        if (safeness[0][0] < mid || safeness[n - 1][n - 1] < mid) {
61            return false;
62        }
63        
64        Queue<int[]> q = new LinkedList<>();
65        boolean[][] visited = new boolean[n][n]; 
66        
67        q.add(new int[]{0, 0});
68        visited[0][0] = true;
69        
70        int[] dRow = {0, 0, -1, 1};
71        int[] dCol = {1, -1, 0, 0};
72        
73        while (!q.isEmpty()) {
74            int[] curr = q.poll();
75            int r = curr[0];
76            int c = curr[1];
77            
78            if (r == n - 1 && c == n - 1) {
79                return true;
80            }
81            
82            for (int i = 0; i < 4; i++) {
83                int nr = r + dRow[i];
84                int nc = c + dCol[i];
85                
86                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && safeness[nr][nc] >= mid) {
87                    visited[nr][nc] = true;
88                    q.add(new int[]{nr, nc});
89                }
90            }
91        }
92        
93        return false;
94    }
95}