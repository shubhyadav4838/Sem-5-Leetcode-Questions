// Last updated: 8/11/2025, 9:43:40 pm
class Solution {
    public static int longestSubarray(int[] arr) {
		
		int[] back = new int[arr.length];
		Arrays.fill(back,1);
		
		int max = 0;
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]<=arr[i+1]) {
				back[i]=back[i+1]+1;
			}
			max = Math.max(max, back[i]);
		}
		
		int idx = 0;
		int n = arr.length;
		int ans = Integer.MIN_VALUE;
		while(idx<back.length-1) {
			int start = idx;
			while(idx<back.length-1 && arr[idx]<=arr[idx+1])idx++;
			if(idx+2<arr.length && arr[idx]<=arr[idx+2]) {
				int res = back[idx+1]+idx-start+1;
				ans = Math.max(ans, res);
			}else if(idx+1<arr.length && idx-1>=0 && arr[idx-1]<=arr[idx+1]) {
				int res = back[idx+1]+idx-start+1;
				ans = Math.max(ans, res);
				
			}
			idx++;
			
		}
//		System.out.println("Max"+max);
//		System.out.println("Ans"+ans);
		return Math.max(ans, Math.min(max+1, n));
		
	
        
    }
}