// Last updated: 19/3/2026, 4:32:08 pm
1class Solution {
2  public static int shortestPath(int[][] arr, int k) {
3        int n = arr.length;
4        int m = arr[0].length;
5        
6        if (k >= n + m - 2) {
7            return n + m - 2;
8        }
9        
10        int[][] maxK = new int[n][m];
11        for(int[] x : maxK) {
12            Arrays.fill(x, -1);
13        }
14        
15        Queue<Pair> q = new LinkedList<>();
16        q.add(new Pair(0, 0, k, 0));
17        maxK[0][0] = k; 
18        
19        int[] dRow = {1, -1, 0, 0};
20        int[] dCol = {0, 0, -1, 1};
21        
22        while(!q.isEmpty()) {
23            Pair curr = q.poll();
24            
25            if(curr.row == n - 1 && curr.col == m - 1) {
26                return curr.maxDis;
27            }
28            
29            for(int i = 0; i < 4; i++) {
30                int crow = curr.row + dRow[i];
31                int ccol = curr.col + dCol[i];
32                
33                if(crow >= 0 && crow < n && ccol >= 0 && ccol < m) {
34                    
35                    int newK = curr.currk;
36                    if(arr[crow][ccol] == 1) {
37                        newK--;
38                    }
39                    
40                    if (newK >= 0 && newK > maxK[crow][ccol]) {
41                        maxK[crow][ccol] = newK; 
42                        
43                        q.add(new Pair(crow, ccol, newK, curr.maxDis + 1));
44                    }
45                }
46            }
47        }
48        return -1;
49    }
50
51	static class Pair {
52		int row;
53		int col;
54		int currk;
55		int maxDis;
56		public Pair(int row, int col, int currk, int maxDis) {
57			this.row = row;
58			this.col = col;
59			this.currk = currk;
60			this.maxDis = maxDis;
61			
62		}
63	}
64}