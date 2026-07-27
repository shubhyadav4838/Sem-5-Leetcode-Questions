// Last updated: 27/7/2026, 11:45:46 am
class Solution {
  public static int shortestPath(int[][] arr, int k) {
        int n = arr.length;
        int m = arr[0].length;
        
        if (k >= n + m - 2) {
            return n + m - 2;
        }
        
        int[][] maxK = new int[n][m];
        for(int[] x : maxK) {
            Arrays.fill(x, -1);
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, k, 0));
        maxK[0][0] = k; 
        
        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            
            if(curr.row == n - 1 && curr.col == m - 1) {
                return curr.maxDis;
            }
            
            for(int i = 0; i < 4; i++) {
                int crow = curr.row + dRow[i];
                int ccol = curr.col + dCol[i];
                
                if(crow >= 0 && crow < n && ccol >= 0 && ccol < m) {
                    
                    int newK = curr.currk;
                    if(arr[crow][ccol] == 1) {
                        newK--;
                    }
                    
                    if (newK >= 0 && newK > maxK[crow][ccol]) {
                        maxK[crow][ccol] = newK; 
                        
                        q.add(new Pair(crow, ccol, newK, curr.maxDis + 1));
                    }
                }
            }
        }
        return -1;
    }

	static class Pair {
		int row;
		int col;
		int currk;
		int maxDis;
		public Pair(int row, int col, int currk, int maxDis) {
			this.row = row;
			this.col = col;
			this.currk = currk;
			this.maxDis = maxDis;
			
		}
	}
}