// Last updated: 4/8/2025, 12:01:43 am
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return FirstAndLastPosition(nums,target);
        
    }
    public static int[] FirstAndLastPosition(int[]arr,int target) {
		int l = 0;
		int h = arr.length-1;
		int [] ans = {-1,-1};
		while(l<=h) {
			int mid = (l+h)/2;
			if(arr[mid]==target) {
				if(arr[l]==target && arr[h] == target) {
					ans[0] = l;
					ans[1] = h;
					return ans;
				}else if(arr[l]!=target) {
					l++;
				}else if (arr[h]!=target) {
					h--;
				}
			}else if(arr[mid]<target) {
				l = mid+1;
			}else if(arr[mid]>target) {
				h = mid-1;
			}
		}
		return ans;
		
	}
}