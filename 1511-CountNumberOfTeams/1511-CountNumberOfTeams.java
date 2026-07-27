// Last updated: 27/7/2026, 11:45:30 am
class Solution {
    public static int numTeams(int[] arr) {
		int n = arr.length;
		int ans = 0;
		for(int i = 1;i<n-1;i++) {
			int si = 0;
			int ei = n-1;
			int lsmall = 0;
			int llarge = 0;
			int rsmall = 0;
			int rlarge = 0;
			int val = arr[i];
			while(si<i) {
				if(arr[si]<val)lsmall++;
				if(arr[si]>val)llarge++;
				si++;
			}
			while(ei>i) {
				if(arr[ei]<val)rsmall++;
				if(arr[ei]>val)rlarge++;
				ei--;
			}
			int total = (lsmall*rlarge)+(llarge*rsmall);
			ans += total;
		}
		return ans;

	}
}