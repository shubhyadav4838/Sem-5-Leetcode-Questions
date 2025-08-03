// Last updated: 4/8/2025, 12:01:32 am
class Solution {
    public int trap(int[] height) {
        return Trapping(height);
    }
    public static int Trapping (int[]arr) {
		int n = arr.length;
		int [] left = new int[n];
		int [] right = new int [n];
		left[0] = arr[0];
		for (int i = 1; i<n; i++) {
			left[i] = Math.max(left[i-1], arr[i]);
		}
		right[n-1] = arr[n-1];
		for(int i = n-2; i>=0; i--) {
			right[i] = Math.max(right[i+1], arr[i]);
		}
		int sum = 0;
		for(int i =0; i<n; i++) {
			sum = sum+ Math.min(left[i], right[i]) - arr[i];
		}
		return sum;
	}
}