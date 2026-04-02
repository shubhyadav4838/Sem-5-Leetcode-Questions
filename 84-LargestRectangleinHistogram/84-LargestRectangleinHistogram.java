// Last updated: 2/4/2026, 12:37:24 pm
1class Solution {
2    public static int largestRectangleArea(int[] arr) {
3		Stack<Integer> st = new Stack<>();
4		int n = arr.length;
5		int ans = 0;
6		
7		for(int i = 0;i<n; i++) {
8			while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
9				int idx = st.pop();
10				int h = arr[idx];
11				
12				int res = 0;
13				if(st.isEmpty()) {
14					res = h*i;
15				}else {
16					res = (h*(i-st.peek()-1));
17				}
18				ans = Math.max(ans, res);
19				
20			}
21			st.push(i);
22		}
23		
24		int r = arr.length;
25		while(!st.isEmpty()) {
26			int idx = st.pop();
27			int h = arr[idx];
28			
29			int res = 0;
30			if(st.isEmpty()) {
31				res = h*r;
32			}else {
33				res = (h*(r-st.peek()-1));
34			}
35			ans = Math.max(ans, res);
36		}
37		
38		
39		
40		return ans;
41		
42
43	}
44
45}