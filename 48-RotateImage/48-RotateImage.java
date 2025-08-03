// Last updated: 4/8/2025, 12:01:26 am
class Solution {
    public void rotate(int[][] matrix) {
        Rotate(matrix);
        
    }
    public static void Rotate(int[][]arr){
        Transpose(arr);
        for(int row = 0; row<arr.length; row++) {
        	for(int col = 0; col<(arr.length/2); col++) {
        		int n = arr.length-col-1;
        		int temp = arr[row][col];
        		arr[row][col] = arr[row][n];
        		arr[row][n] = temp;
        		
        	}
        }
    }
	public static void Transpose(int[][]arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = i+1; j<arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}	
		}
	}
}