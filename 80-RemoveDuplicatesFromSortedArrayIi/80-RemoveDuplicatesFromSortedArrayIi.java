// Last updated: 4/8/2025, 12:00:43 am
class Solution {
    public int removeDuplicates(int[] nums) {
        return RemoveDublicates(nums);
    }
    public static int RemoveDublicates(int[]arr) {
		if(arr.length<3) {
			return arr.length;
		}
		int j= 2;
		for(int i=2; i<arr.length; i++) {
			if(arr[i]!=arr[j-2]) {
				arr[j] = arr[i];
				j++;
			}
		}return j;
	}
}