// Last updated: 3/8/2025, 11:58:14 pm
class Solution {
    public int[] findRightInterval(int[][] intervals) {
       return rightInterval(intervals); 
    }
    public static int[] rightInterval(int[][]arr) {
		 int[]ans = new int[arr.length];
		 for(int i=0;i<arr.length;i++) {
			 ans[i]=isPresent(arr[i][1],arr);
		 }
		 return ans;
	}
	public static int isPresent(int target, int[][]arr) {
		int num=Integer.MAX_VALUE;
		int res = -1;
		for(int row=0;row<arr.length;row++) {
			if(arr[row][0]==target) {
				return row;
			}else if(arr[row][0]>target) {
				if(arr[row][0]<num) {
					num=arr[row][0];
					res = row;
				}
			}
		}
		return res;
	}
	
}