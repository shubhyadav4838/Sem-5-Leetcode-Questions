// Last updated: 3/8/2025, 11:59:42 pm
class Solution {
    public int numIslands(char[][] grid) {
        return island(grid);
    }
    public static int island(char[][]arr) {
		int n = 0;
		for(int row = 0;row<arr.length;row++) {
			for(int col = 0;col<arr[0].length;col++) {
				if(arr[row][col]=='1') {
					count(arr,row,col);
					n++;
				}
			}
		}
		return n;
	}
	public static void count(char[][]arr,int r, int c) {
		if(r<0 || r>=arr.length || c<0 || c>=arr[0].length || arr[r][c]=='0') {
			return;
		}
		arr[r][c]='0';
		count(arr,r+1,c);
		count(arr,r-1,c);
		count(arr,r,c+1);
		count(arr,r,c-1);
	}
}