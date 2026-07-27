// Last updated: 27/7/2026, 11:45:04 am
class Solution {
    public static int minOperations(int[] arr, int x) {
		int n = arr.length;
		int[] pre = new int[n];
		int ans = Integer.MAX_VALUE;
		pre[0] = arr[0];
		if(pre[0]==x) {
			ans = 1;
		}
		for(int i = 1;i<arr.length;i++) {
			pre[i] = arr[i]+pre[i-1];
			if(pre[i]==x) {
				ans = Math.min(ans, i+1);
			}
		}
		long sum = 0;
		for(int i = n-1; i>=0 && sum<=x ;i--) {
			sum += arr[i];
			if(sum==x) {
				ans = Math.min(ans, n-i);
				
			}
			int req = (int)(x-sum);
			int idx = getIdx(pre,i-1,0,req);
			if(idx==-1)continue;
			
			if(pre[idx] == req) {
				int val = n-i + idx+1;
				ans = Math.min(ans, val);
			}
			
		}
		return ans==Integer.MAX_VALUE ? -1:ans;
		
		
	}
	public static int getIdx(int[] arr, int hi, int lo, int target) {
		int ans = -1;
		while(lo<=hi) {
			int mid = lo+((hi-lo)/2);
			if(arr[mid]>=target) {
				ans = mid;
				hi = mid-1;
			}else {
				lo = mid +1;
			}
		}
		return ans;
	}
}