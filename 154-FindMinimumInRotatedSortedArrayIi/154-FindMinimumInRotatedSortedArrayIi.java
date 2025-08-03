// Last updated: 4/8/2025, 12:00:00 am
class Solution {
    public int findMin(int[] nums) {
        return FindMinimum(nums);
        
    }
  public static int FindMinimum(int[]arr) {
		int l = 0;
		int h = arr.length-1;
		int ans = Integer.MAX_VALUE;
//		System.out.println("In function");
		if(arr[l]<arr[h]){
			return arr[0];
		}else {
			while(l<=h) {
				int mid = (l+h)/2;
				ans = Math.min(ans, arr[mid]);
				if(arr[l]==arr[mid] && arr[h]==arr[mid]) {
					l++;
					h--;
//					
				}
				else if(arr[mid]>arr[h]) {
					l = mid+1;
				}else {
					h = mid-1;
				}
//				System.out.println("In else");
				
			}
			return ans;
			
		}
		
		
	}
}