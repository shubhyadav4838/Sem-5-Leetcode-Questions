// Last updated: 3/8/2025, 11:54:08 pm
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        return MinimizedMaximum(n, quantities);
        
    }
    public static int MinimizedMaximum(int n, int []arr) {
		// Arrays.sort(arr);
		int lo = 1;
		int hi = 100000;
		int ans = 0;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if(isPossible(n, arr, mid)) {
				hi= mid-1;
				ans = mid;
			}else {
				lo= mid+1;
			}			
		}
		return ans;
	}
	
	
	public static boolean isPossible(int n, int[] arr, int mid) {
        int store = 0;

        for (int qty : arr) {
            store += (qty + mid - 1) / mid;  
            if (store > n) {
                return false;
            }
        }

        return store <= n;
    }
	
}