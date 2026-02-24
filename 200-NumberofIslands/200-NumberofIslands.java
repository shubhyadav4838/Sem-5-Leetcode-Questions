// Last updated: 24/2/2026, 3:21:53 pm
1class Solution {
2    public int numIslands(char[][] grid) {
3        int count = 0;
4        for(int i = 0; i<grid.length;i++){
5            for(int j = 0;j<grid[0].length;j++){
6                if(grid[i][j]=='1'){
7                    count++;
8                    solve(grid,i,j);
9                }
10            }
11        }
12        return count;
13        
14    }
15    public static void solve(char[][] grid, int r, int c){
16        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0'){
17            return;
18        }
19        grid[r][c] = '0';
20        solve(grid,r+1,c);
21        solve(grid,r-1,c);
22        solve(grid,r,c+1);
23        solve(grid,r,c-1);
24    }
25}