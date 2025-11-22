// Last updated: 22/11/2025, 9:01:52 pm
class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        return lexSmall(n,target);
    }
     public static int[] lexSmall(int n, long target) {
    	long max = (long)n * (n + 1) / 2;
    	if (target > max || target < -max) {
            return new int[0];
        }
    	
    	int[] arr = new int[n];
    	for(int i=0;i<arr.length;i++) {
    		arr[i] = i+1;
    	}
    	
    	long dif = max - target;

        if (dif % 2 != 0) {
            return new int[0];
        }
        dif = dif/2;
    	for(int i=arr.length-1;i>=0;i--) {
    		if(dif==0)break;
    		if(arr[i]<=dif) {
    			dif-=arr[i];
    			arr[i] = -1*arr[i];
    		}
    		
    	}
    
    	Arrays.sort(arr);
    	return arr;
    }
}