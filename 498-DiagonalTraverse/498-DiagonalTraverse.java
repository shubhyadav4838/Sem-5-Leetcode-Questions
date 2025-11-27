// Last updated: 27/11/2025, 8:05:39 pm
1class Solution {
2    public int[] findDiagonalOrder(int[][] mat) {
3        if (mat.length == 0 || mat[0].length == 0) return new int[0];
4
5        int m = mat.length, n = mat[0].length;
6        int[] arr = new int[m * n];
7        int i = 0, row = 0, col = 0;
8        boolean flag = true;
9
10        while (i < m * n) {
11            arr[i++] = mat[row][col];
12
13            if (flag) {
14                if (col == n - 1) {
15                    row++;
16                    flag = false;
17                } else if (row == 0) {
18                    col++;
19                    flag = false;
20                } else {
21                    row--;
22                    col++;
23                }
24            } else {
25                if (row == m - 1) {
26                    col++;
27                    flag = true;
28                } else if (col == 0) {
29                    row++;
30                    flag = true;
31                } else {
32                    row++;
33                    col--;
34                }
35            }
36        }
37
38        return arr;
39    }
40}