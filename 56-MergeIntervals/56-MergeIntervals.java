// Last updated: 4/8/2025, 12:01:14 am
class Solution {
    public int[][] merge(int[][] intervals) {
        return me(intervals);
    }
    public static int[][] me(int[][]arr) {
        Arrays.sort(arr, (row1, row2) -> Integer.compare(row1[0], row2[0]));
		ArrayList<Integer> ll = new ArrayList<>();
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
        if(count==0){
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