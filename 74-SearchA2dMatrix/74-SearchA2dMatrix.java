// Last updated: 4/8/2025, 12:00:50 am
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return Search(matrix,target);
        
    }
    public static boolean Search(int[][]arr,int target) {
		int l = 0;
		int h = arr.length-1;
		int row = h;
        if(target<arr[0][0]) {
			return false;
		}
		while(l<=h) {
			int mid = (l+h)/2;
			if(target==arr[mid][0]) {
				row = mid;
				break;
				
			}else if(target<arr[mid][0]) {
				h = mid-1;
				row = mid-1;
			}
			else {
				l= mid+1;
			}
		}
		int cl = 0;
		int ch = arr[0].length-1;
		boolean find = false;
		while(cl<=ch) {
			int mid = (cl+ch)/2;
			if(arr[row][mid]==target) {
				find = true;
				return find;
			}else if(arr[row][mid]>target) {
				ch = mid-1;
			}else {
				cl = mid+1;
			}
		}
		return find;
		
	}

    
}