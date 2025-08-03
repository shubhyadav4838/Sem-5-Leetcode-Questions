// Last updated: 4/8/2025, 12:01:21 am
import java.util.*;

public class Solution {

    private boolean isSafe(List<String> board, int row, int col, int n) {
        // Horizontal Check
        for (int j = 0; j < n; j++) {
            if (board.get(row).charAt(j) == 'Q') {
                return false;
            }
        }

        // Vertical Check
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Left Diagonal Check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Right Diagonal Check
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void nQueen(List<String> board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                char[] rowChars = board.get(row).toCharArray();
                rowChars[j] = 'Q';
                board.set(row, new String(rowChars));

                nQueen(board, row + 1, n, ans);

                rowChars[j] = '.';
                board.set(row, new String(rowChars));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        List<List<String>> ans = new ArrayList<>();
        nQueen(board, 0, n, ans);
        return ans;
    }
}
