// Last updated: 8/11/2025, 8:35:24 pm
class Solution {
   public static int countMajoritySubarrays(int[] arr, int target) {
    	int ans = 0;
    	int[] count = new int[arr.length];
    	if(arr[0]==target) {
    		count[0] = 1;
    	}
        for(int i=1;i<arr.length;i++) {
        	count[i] = count[i-1];
        	if(arr[i]==target)count[i]++;
        }
        for(int len = 1;len<=arr.length;len++) {
        	for(int j=0;j<arr.length && j+len-1<arr.length;j++) {
        		int sum = 0;
        		int i=j+len-1;
        		if(j==0) {
        			sum = count[i];
        		}else {
        			sum = count[i]-count[j-1];
        		}
        		if(sum>len/2)ans++;
        		
        	}
        }
        return ans;
        
    }
}