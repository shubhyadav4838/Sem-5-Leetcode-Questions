// Last updated: 19/1/2026, 5:54:21 pm
1class Solution {
2    public static int longestBalanced(int[] arr) {
3		int n = arr.length;
4		int ans = 0;
5		for(int i = 0;i<n;i++) {
6			HashSet<Integer> set = new HashSet<>();
7			set.add(arr[i]);
8			int even = 0;
9			int odd = 0;
10			if(arr[i]%2==0)even++;
11			else odd++;
12			for(int j = i+1;j<n;j++) {
13				if(!set.contains(arr[j])) {
14					set.add(arr[j]);
15					if(arr[j]%2==0)even++;
16					else odd++;
17				}
18				
19				if(even==odd) {
20					ans = Math.max(ans, j-i+1);
21				}
22			}
23		}
24		return ans;
25
26	}
27}