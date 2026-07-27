// Last updated: 27/7/2026, 11:44:34 am
class Solution {
    public static int eliminateMaximum(int[] dist, int[] speed) {
		int[] ans = new int[dist.length];
		for(int i = 0;i<dist.length;i++) {
			ans[i] = Math.ceilDiv(dist[i], speed[i]);
		}
		Arrays.sort(ans);
		int res = 1;
		for(int i = 1;i<ans.length;i++) {
			if(ans[i]<0 || ans[i]<=i) {
				break;
			}
			res++;
		}
		return res;
	}
}