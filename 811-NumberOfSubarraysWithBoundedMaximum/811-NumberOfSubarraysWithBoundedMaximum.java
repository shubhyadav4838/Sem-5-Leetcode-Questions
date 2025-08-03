// Last updated: 3/8/2025, 11:56:39 pm
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countSubarray(nums,left,right);
    }
    public static int countSubarray(int[]arr,int l,int r) {
		int count = 0,i=0,j=0,m=0;
        while(j<arr.length){
            if(arr[j]>r){
                m=0;
                i=j+1;
            }else if(arr[j]<=r && arr[j]>=l){
                m = j-i+1;
            }
            count+=m;
            j++;
        }
        return count;
	}
	
}