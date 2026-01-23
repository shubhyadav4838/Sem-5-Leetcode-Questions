// Last updated: 23/1/2026, 10:39:51 pm
1class Solution {
2    public static int countSquares(int[][] arr) {
3		int ans = 0;
4		for(int i = 0;i<arr.length;i++) {
5			ans+=arr[i][0];
6		}
7		for(int i = 1; i < arr[0].length;i++) {
8			ans+=arr[0][i];
9		}
10		
11		for(int i =1;i<arr.length;i++) {
12			for(int j = 1;j<arr[0].length;j++) {
13				if(arr[i][j] == 0)continue;
14				arr[i][j] = 1+Math.min(arr[i-1][j], Math.min(arr[i-1][j-1], arr[i][j-1]));
15				ans+= arr[i][j];
16			}
17		}
18		return ans;
19	}
20}