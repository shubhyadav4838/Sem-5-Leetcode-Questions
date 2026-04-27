// Last updated: 27/4/2026, 11:12:13 pm
1class Solution {
2    static class Pair {
3        int row, col;
4
5        public Pair(int row, int col) {
6            this.row = row;
7            this.col = col;
8        }
9    }
10
11    public static boolean hasValidPath(int[][] arr) {
12        int[][][] opr = { { { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 1, 0 } }, { { 0, -1 }, { 1, 0 } },
13                { { 0, 1 }, { 1, 0 } }, { { -1, 0 }, { 0, -1 } }, { { 0, 1 }, { -1, 0 } } };
14        int n = arr.length;
15        int m = arr[0].length;
16        boolean[][] visited = new boolean[n][m];
17
18        Queue<Pair> q = new LinkedList<>();
19        q.add(new Pair(0, 0));
20        visited[0][0] = true;
21        while (!q.isEmpty()) {
22
23            Pair curr = q.poll();
24            if (curr.row == n - 1 && curr.col == m - 1) {
25                return true;
26            }
27
28            int i = arr[curr.row][curr.col];
29            for (int j = 0; j < 2; j++) {
30                int dr = curr.row + opr[i - 1][j][0];
31                int dc = curr.col + opr[i - 1][j][1];
32                if (dr >= 0 && dr < n && dc >= 0 && dc < m && !visited[dr][dc]) {
33                    for (int[] back : opr[arr[dr][dc]-1]) {
34                        if (dr + back[0] == curr.row && dc + back[1] == curr.col) {
35                            visited[dr][dc] = true;
36                            q.add(new Pair(dr, dc));
37                        }
38                    }
39
40                }
41
42            }
43
44        }
45        return false;
46
47    }
48}