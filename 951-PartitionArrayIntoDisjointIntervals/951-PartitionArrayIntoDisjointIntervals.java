// Last updated: 3/8/2025, 11:56:15 pm
class Solution {
    public int partitionDisjoint(int[] nums) {
        return Partition(nums);
    }
    public static int Partition(int[]arr) {
		int lmax = arr[0];
		int max = arr[0];
		int len = 1;
		for(int i=1;i<arr.length;i++) {
			if(lmax>arr[i]) {
				len=i+1;
				lmax = max;
			}else {
				max = Math.max(max, arr[i]);
			}
		}
		return len;
	}
}