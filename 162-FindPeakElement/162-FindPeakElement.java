// Last updated: 3/8/2025, 11:59:55 pm
class Solution {
    public int findPeakElement(int[] nums) {
        return PeakElement(nums);
    }
   public static int PeakElement(int[]arr) {
		int ans = 0;
		int l = 0;
		int h = arr.length;
		if(arr.length==1){
            return 0;
        }else if(arr.length==2){
            if(arr[0]>arr[1]){
                return 0;
            }else{
                return 1;
            }
        }
		while (l < h) {
	        int mid = l + (h - l) / 2; 

	        if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
	            l = mid + 1;
	        } else {
	            h = mid;  
	        }
	    }
	    
	    return l;
	}


}