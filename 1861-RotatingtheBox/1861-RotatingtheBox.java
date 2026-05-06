// Last updated: 6/5/2026, 9:04:00 pm
1class Solution {
2    public char[][] rotateTheBox(char[][] grid) {
3        int rows = grid.length;
4        int cols = grid[0].length;
5        for (int r = 0; r < rows; r++) {
6            int p = 0;
7            for (int c = 0; c < cols; c++) {
8                if (grid[r][c] == '.') {
9                    char temp = grid[r][c];
10                    grid[r][c] = grid[r][p];
11                    grid[r][p] = temp;
12                    p++;
13                } else if (grid[r][c] == '*')
14                    p = c + 1;
15            }
16        }
17        
18        char[][] res = new char[cols][rows];
19        for (int r = 0; r < rows; r++)
20            for (int c = 0; c < cols; c++)
21                res[c][rows - 1 - r] = grid[r][c];
22                
23        return res;
24    }
25}