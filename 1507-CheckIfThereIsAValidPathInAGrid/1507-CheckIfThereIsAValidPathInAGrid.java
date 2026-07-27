// Last updated: 27/7/2026, 11:45:32 am
class Solution {
    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean hasValidPath(int[][] arr) {
        int[][][] opr = { { { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 1, 0 } }, { { 0, -1 }, { 1, 0 } },
                { { 0, 1 }, { 1, 0 } }, { { -1, 0 }, { 0, -1 } }, { { 0, 1 }, { -1, 0 } } };
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {

            Pair curr = q.poll();
            if (curr.row == n - 1 && curr.col == m - 1) {
                return true;
            }

            int i = arr[curr.row][curr.col];
            for (int j = 0; j < 2; j++) {
                int dr = curr.row + opr[i - 1][j][0];
                int dc = curr.col + opr[i - 1][j][1];
                if (dr >= 0 && dr < n && dc >= 0 && dc < m && !visited[dr][dc]) {
                    for (int[] back : opr[arr[dr][dc]-1]) {
                        if (dr + back[0] == curr.row && dc + back[1] == curr.col) {
                            visited[dr][dc] = true;
                            q.add(new Pair(dr, dc));
                        }
                    }

                }

            }

        }
        return false;

    }
}