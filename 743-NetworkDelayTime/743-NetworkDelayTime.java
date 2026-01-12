// Last updated: 12/1/2026, 6:08:25 pm
1class Solution {
2    public static int eliminateMaximum(int[] dist, int[] speed) {
3		int[] ans = new int[dist.length];
4		for(int i = 0;i<dist.length;i++) {
5			ans[i] = Math.ceilDiv(dist[i], speed[i]);
6		}
7		Arrays.sort(ans);
8		int res = 1;
9		for(int i = 1;i<ans.length;i++) {
10			if(ans[i]<0 || ans[i]<=i) {
11				break;
12			}
13			res++;
14		}
15		return res;
16	}
17}