// Last updated: 3/8/2025, 11:57:44 pm
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return new int[0];

        int m = mat.length, n = mat[0].length;
        int[] arr = new int[m * n];
        int i = 0, row = 0, col = 0;
        boolean flag = true;

        while (i < m * n) {
            arr[i++] = mat[row][col];

            if (flag) {
                if (col == n - 1) {
                    row++;
                    flag = false;
                } else if (row == 0) {
                    col++;
                    flag = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    col++;
                    flag = true;
                } else if (col == 0) {
                    row++;
                    flag = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return arr;
    }
}