// Last updated: 3/8/2025, 11:54:11 pm
class Solution {
    public int minOperations(int[][] grid, int x) {
       return uniqueValue(grid,x); 
    }
    public static int uniqueValue(int[][]arr, int x) {
		int[] ans = new int[arr.length*arr[0].length];
		int idx = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				ans[idx]=arr[i][j];
				idx++;
			}
		}
		Arrays.sort(ans);
		int moves = 0;
		int num = ans[ans.length/2];
		for(int i=0;i<ans.length;i++) {
			if(ans[i]<num) {
				int toadd = num-ans[i];
				if(toadd%x!=0)return -1;
				moves+=toadd/x;
			}else if(ans[i]>num) {
				int toadd=ans[i]-num;
				if(toadd%x!=0)return -1;
				moves+=toadd/x;
			}
		}
		return moves;
	}
}