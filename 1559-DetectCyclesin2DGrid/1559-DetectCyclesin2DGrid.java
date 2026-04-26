// Last updated: 26/4/2026, 11:47:47 pm
1class Solution {
2    static int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
3
4    public boolean containsCycle(char[][] grid) {
5        int m = grid.length;
6        int n = grid[0].length;
7        boolean[] visit = new boolean[m * n];
8
9        for (int i = 0; i < m; i++)
10            for (int j = 0; j < n; j++)
11                if (!visit[i * n + j] && dfs(i, j, -1, -1, grid, visit, m, n))
12                    return true;
13        return false;
14    }
15
16    private static boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[] visit, int m, int n) {
17        visit[r * n + c] = true;
18        for (int[] d : dirs) {
19            int nr = r + d[0];
20            int nc = c + d[1];
21            if (nr != pr || nc != pc)
22                if (nr >= 0 && nr < m && nc >= 0 && nc < n)
23                    if (grid[nr][nc] == grid[r][c])
24                        if (visit[nr * n + nc] || dfs(nr, nc, r, c, grid, visit, m, n))
25                            return true;
26        }
27        return false;
28    }
29}