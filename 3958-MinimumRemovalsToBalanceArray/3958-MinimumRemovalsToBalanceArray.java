// Last updated: 27/7/2026, 11:42:45 am
class Solution {
  public static int minRemoval(int[] arr, int k) {
		Arrays.sort(arr);
		int n = arr.length;
		int i = 0;
		int j = 0;
		int maxlen = 0;
		while(j<n ) {
			while( (long)arr[i]*k <arr[j]) {
				i++;
			}
			
			maxlen = Math.max(maxlen, j-i+1);
			j++;
		}
		return n-maxlen;
		
	}
	
}