// Last updated: 3/8/2025, 11:54:24 pm
class Solution {
    public int minPairSum(int[] nums) {
        return MaxPairSum(nums);
    }
    public static int MaxPairSum(int[]arr) {
		Arrays.sort(arr);
		int min = 0;
		int max = arr.length-1;
		int ans = 0;
		while(min<max) {
			int sum = arr[min]+arr[max];
			if(sum>ans){
                ans = sum;
            }
			min++;
			max--;
		}
		return ans;
		
	}

}