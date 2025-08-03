// Last updated: 3/8/2025, 11:59:16 pm
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return Search(matrix, target);
    }
    public static boolean Search(int[][]arr, int item) {
		int row = 0;
		int col = arr[0].length-1;
		while(row<arr.length && col>=0) {
			if(arr[row][col]==item) {
				return true;
			}else if(arr[row][col]>item) {
				col--;
			}else {
				row++;
			}
		}
		return false;
	}
}