// Last updated: 4/8/2025, 12:01:12 am
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       return merge(intervals, newInterval); 
    }
    public static int[][] merge(int[][]intervals, int[] add) {
        if(intervals.length==0){
            int[][]ans=new int[1][2];
            ans[0][0]=add[0];
            ans[0][1]=add[1];
            return ans;
        }
		int[][]arr = new int[intervals.length+1][2];
		int i=0;
		boolean flag=false;
		for(int row=0; row<arr.length;row++) {
			if((i<intervals.length  && intervals[i][0]<add[0]) || flag) {
				arr[row][0]=intervals[i][0];
				arr[row][1]=intervals[i][1];
				i++;
			}else {
				arr[row][0]=add[0];
				arr[row][1]=add[1];
				flag=true;
			}
		}
		boolean []change = new  boolean[arr.length];
		int count=0;
		for(int row=1;row<arr.length;row++) {
			if(arr[row][0]<=arr[row-1][1]) {
				arr[row][0]=Math.min(arr[row][0], arr[row-1][0]);
				arr[row][1]=Math.max(arr[row][1], arr[row-1][1]);
				change[row-1]=true;
				count++;
			}
		}
		if(count==0) {
			return arr;
		}
		int[][] res = new int[arr.length-count][2];
		int idx=0;
		for(int row=0;row<arr.length;row++) {
			if(!change[row]) {
				res[idx][0]=arr[row][0];
				res[idx][1]=arr[row][1];
				idx++;
			}
		}
        return res;
		
	}
}