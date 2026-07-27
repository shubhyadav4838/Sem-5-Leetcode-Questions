// Last updated: 27/7/2026, 11:41:58 am
class Solution {
   public static int minimumK(int[] arr) {
		long lo = 1;
		long hi = 0;
		
		for(int x:arr) {
			hi += x;

		}
		long ans = 0;
		while(lo<=hi) {
			long mid = lo+((hi-lo)/2);
			if(ispossible(arr,mid)) {
				ans = mid;
				hi = mid-1;
			}else {
				lo = mid+1;
			}
		}
		return (int)ans;

	}

	private static boolean ispossible(int[] arr, long mid) {
		// TODO Auto-generated method stub
		long count = 0;
		for(int i = 0;i<arr.length;i++) {
			long n = (long)((long)(arr[i])/mid);
			if(arr[i]%mid!=0) {
				n++;
			}
			count += n;
			
			
			
		}
		
		long sqr = (long)(mid*mid);
		return count<=sqr;
	}
}