// Last updated: 1/9/2025, 10:48:27 pm
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int [][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean [][] visited = new boolean[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new Pair(grid[0][0],0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int t = curr.time;
            int r = curr.row;
            int c = curr.col;

            if(r == n-1 && c == n-1) return t;

            for(int [] dir : directions){
                int row = r+dir[0];
                int col = c+dir[1];

                if (row<0 || col< 0 || row >= n || col >= n || visited[row][col]) continue;

                visited[row][col] = true;
                pq.offer(new Pair(Math.max(t, grid[row][col]), row, col));
            }


        }
        return -1;  
    }

    class Pair{
        int time;
        int row;
        int col;

        Pair(int time, int row, int col){
            this.time = time;
            this.row = row;
            this.col = col; 
        }
    }
}