// Last updated: 3/8/2025, 11:59:50 pm
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return FindIndex(numbers, target);
    }
    public static int[] FindIndex(int[]arr, int target) {
		int l = 0;
		int h = arr.length-1;
		int[]ans = new int[2];
		while(l<h) {
			int mid = (l+h)/2;
			if(target==0) {
				if(Math.abs(arr[l])>arr[h]) {
					l++;
					
				}
				if(arr[l]+arr[h]==0) {
					ans[0] = l+1;
					ans[1] = h+1;
					break;
				}else if(arr[mid]>Math.abs(arr[l])) {
					h = mid-1;
				}else if (arr[mid]<=Math.abs(arr[l])) {
					h--;
				}
			}else {
				
			
			if(arr[mid]>target) {
				int sum =arr[l]+arr[h];
				if(sum==target) {
					ans[0] = l+1;
					ans[1] = h+1;
//					System.out.println("Nested if");
					break;
				}
				h = mid;
//				System.out.println("IN if");
			}else {
				int sum =arr[l]+arr[h];
				if(sum==target) {
					ans[0] = l+1;
					ans[1] = h+1;
					break;
				}else if(sum>target) {
					h--;
				}else {
					l++;
					
				}
				
			}
		}
		}
		return ans;
	}

}