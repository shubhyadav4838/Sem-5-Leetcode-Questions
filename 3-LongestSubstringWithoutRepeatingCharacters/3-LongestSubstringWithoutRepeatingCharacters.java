// Last updated: 13/2/2026, 6:35:15 pm
1class Solution {
2    public static int lengthOfLongestSubstring(String s) {
3		int[] arr = new int[256];
4		int lo = 0;
5		int ans = 0;
6		for(int i = 0;i<s.length();i++) {
7			char ch = s.charAt(i);
8			arr[ch]++;
9			while(arr[ch]>1) {
10				arr[s.charAt(lo)]--;
11				lo++;
12			}
13			ans = Math.max(ans, i-lo+1);
14		}
15		return ans;
16
17	}
18}