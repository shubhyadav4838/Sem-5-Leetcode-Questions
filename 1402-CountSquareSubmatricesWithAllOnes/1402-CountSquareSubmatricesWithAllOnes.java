// Last updated: 27/7/2026, 11:45:47 am
class Solution {
    public static int countSquares(int[][] arr) {
		int ans = 0;
		for(int i = 0;i<arr.length;i++) {
			ans+=arr[i][0];
		}
		for(int i = 1; i < arr[0].length;i++) {
			ans+=arr[0][i];
		}
		
		for(int i =1;i<arr.length;i++) {
			for(int j = 1;j<arr[0].length;j++) {
				if(arr[i][j] == 0)continue;
				arr[i][j] = 1+Math.min(arr[i-1][j], Math.min(arr[i-1][j-1], arr[i][j-1]));
				ans+= arr[i][j];
			}
		}
		return ans;
	}
}