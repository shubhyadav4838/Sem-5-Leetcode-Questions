// Last updated: 4/8/2025, 12:00:20 am
class Solution {
    public void solve(char[][] board) {
       for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O')
				capture(board, i, 0);
			if (board[i][board[0].length - 1] == 'O')
				capture(board, i, board[0].length - 1);
		}
		for(int i=0;i<board[0].length;i++) {
			if(board[0][i]=='O')capture(board,0,i);
			if(board[board.length-1][i]=='O')capture(board,board.length-1,i);
		}
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='O')board[i][j] = 'X';
				if(board[i][j]=='K')board[i][j]='O';
				
			}
		}
    }
    public static void capture(char[][] arr, int cr, int cc) {
		if (cr < 0 || cc < 0 || cr == arr.length  || cc == arr[0].length || arr[cr][cc] == 'X') {
			return;
		}
		if (arr[cr][cc] == 'O') {
			arr[cr][cc] = 'K';
			capture(arr, cr + 1, cc);
			capture(arr, cr - 1, cc);
			capture(arr, cr, cc + 1);
			capture(arr, cr, cc - 1);
			
		}
	}
}