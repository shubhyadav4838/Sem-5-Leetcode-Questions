// Last updated: 19/3/2026, 12:51:33 pm
1class Solution {
2    static class Pair {
3		int row;
4		int col;
5
6		public Pair(int r, int c) {
7			this.row = r;
8			this.col = c;
9		}
10
11	}
12
13	public static int orangesRotting(int[][] arr) {
14		Queue<Pair> q = new LinkedList<>();
15		int n = arr.length;
16		int m = arr[0].length;
17		int ans = -1;
18		int total = 0;
19		int recent = 0;
20		for(int i =0; i<n; i++ ) {
21			for(int j = 0; j<m; j++) {
22				if(arr[i][j]==2) {
23					arr[i][j] = 0;
24					q.add(new Pair(i,j));
25				}else if(arr[i][j]==1) {
26					arr[i][j] = -1;
27					total++;
28				}
29			}
30		}
31        if(total==0)return 0;
32		int[] drow = {0,0,1,-1};
33		int[] dcol = {-1,1,0,0};
34		while(!q.isEmpty()) {
35			Pair curr = q.poll();
36			int r = curr.row;
37			int c = curr.col;
38			
39			for(int i = 0;i<4; i++) {
40				int row = r+drow[i];
41				int col = c+dcol[i];
42				
43				
44				if(row<n && row>=0 && col<m && col>=0 && arr[row][col]==-1) {
45					recent++;
46					arr[row][col] = arr[r][c]+1;
47					ans = Math.max(ans, arr[row][col]);
48					q.add(new Pair(row,col));
49				}
50				
51			}
52			
53		}
54		return (total==recent)? ans:-1;
55	}
56}