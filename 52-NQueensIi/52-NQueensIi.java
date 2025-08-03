// Last updated: 4/8/2025, 12:01:20 am
class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return countQueens(board, 0);
    }

    private int countQueens(boolean[][] board, int row) {
        if (row == board.length) {
            return 1; // Found a valid solution
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += countQueens(board, row + 1); // Recurse
                board[row][col] = false; // Backtrack
            }
        }

        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Check top-left diagonal
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i]) return false;
        }

        // Check top-right diagonal
        for (int i = 1; row - i >= 0 && col + i < board.length; i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }
}