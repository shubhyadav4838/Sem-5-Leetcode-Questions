// Last updated: 27/7/2026, 11:42:34 am
class Solution {
    public static int longestBalanced(int[] arr) {
		int n = arr.length;
		int ans = 0;
		for(int i = 0;i<n;i++) {
			HashSet<Integer> set = new HashSet<>();
			set.add(arr[i]);
			int even = 0;
			int odd = 0;
			if(arr[i]%2==0)even++;
			else odd++;
			for(int j = i+1;j<n;j++) {
				if(!set.contains(arr[j])) {
					set.add(arr[j]);
					if(arr[j]%2==0)even++;
					else odd++;
				}
				
				if(even==odd) {
					ans = Math.max(ans, j-i+1);
				}
			}
		}
		return ans;

	}
}