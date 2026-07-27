// Last updated: 27/7/2026, 11:46:59 am
class Solution {
    public static int sumSubarrayMins(int[] arr) {
		int n = arr.length;
		int[] pre =new int[n];
		int[] suf = new int[n];
		
		Stack<Integer> p = new Stack<>();
		Stack<Integer> s = new Stack<>();
		long MOD = (long)(1e9 + 7);
		
		for(int i = 0;i<n;i++) {
			while(!p.isEmpty() && arr[p.peek()] >= arr[i]) {
				p.pop();
			}
			
			if(p.isEmpty()) {
				pre[i] = -1;
			}else {
				pre[i] = p.peek();
			}
			p.push(i);
		}
		
		for(int i = n-1;i>=0;i--) {
			while(!s.isEmpty() && arr[s.peek()] > arr[i]) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				suf[i] = n;
			}else {
				suf[i] = s.peek();
			}
			s.push(i);
		}
		
		long sum = 0;
		for(int i = 0;i<arr.length;i++) {
			long right = suf[i] - i;
			long left = i - pre[i];
			long cont = (right*left)%MOD;
			long val = (arr[i]*cont)%MOD;
			sum = (sum + val ) % MOD;
		}
		
		return (int)sum;

	}
}