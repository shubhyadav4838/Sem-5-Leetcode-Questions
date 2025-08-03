// Last updated: 3/8/2025, 11:59:19 pm
class Solution {
    public int[] productExceptSelf(int[] nums) {
        return Product(nums);
    }
    public static int[] Product(int[]arr) {
		int n = arr.length;
		int [] left = new int [n];
		int [] right = new int [n];
		left[0] = 1;
		for(int i = 1; i<n; i++) {
			left[i] = left[i-1] *arr[i-1];
		}
		right [n-1] = 1;
		for(int i = n-2; i>=0; i--) {
			right[i] = right[i+1]*arr[i+1];
		}
		
//		Kisi bhi array me store krr lo, left ya right 
		for(int i = 0; i<n; i++) {
			left[i] = left[i]*right[i];
		}
		return left;

		
	}
}