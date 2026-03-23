// Last updated: 23/3/2026, 10:33:56 pm
1class Solution {
2    public static int[][] updateMatrix(int[][] arr) {
3		int n = arr.length;
4		int m = arr[0].length;
5		
6		int[][] dis = new int[n][m];
7		Queue<Pair> q = new LinkedList<>();
8		
9		for(int i = 0;i<n;i++) {
10			for(int j = 0; j<m;j++) {
11				if(arr[i][j] == 0) {
12					dis[i][j] = 0;
13					q.add(new Pair(i,j));
14				}else {
15					dis[i][j] = -1;
16				}
17			}
18		}
19		int[] dRow = {-1, 1, 0, 0};
20		int[] dCol = {0, 0, -1, 1};
21		
22		while(!q.isEmpty()) {
23			Pair curr = q.poll();
24			int r = curr.row;
25			int c = curr.col;
26			for(int i = 0; i<4;i++) {
27				int nrow = r+dRow[i];
28				int ncol = c+dCol[i];
29				
30				if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && dis[nrow][ncol]==-1) {
31					dis[nrow][ncol] = dis[r][c]+1;
32					q.add(new Pair(nrow,ncol));
33				}
34			}
35		}
36		return dis;
37	}
38    static class Pair{
39		int row;
40		int col;
41		public Pair(int r, int c) {
42			this.row = r;
43			this.col = c;
44		}
45		
46	}
47}