// Last updated: 19/1/2026, 11:29:31 am
1class Solution {
2    public static int sumSubarrayMins(int[] arr) {
3		int n = arr.length;
4		int[] pre =new int[n];
5		int[] suf = new int[n];
6		
7		Stack<Integer> p = new Stack<>();
8		Stack<Integer> s = new Stack<>();
9		long MOD = (long)(1e9 + 7);
10		
11		for(int i = 0;i<n;i++) {
12			while(!p.isEmpty() && arr[p.peek()] >= arr[i]) {
13				p.pop();
14			}
15			
16			if(p.isEmpty()) {
17				pre[i] = -1;
18			}else {
19				pre[i] = p.peek();
20			}
21			p.push(i);
22		}
23		
24		for(int i = n-1;i>=0;i--) {
25			while(!s.isEmpty() && arr[s.peek()] > arr[i]) {
26				s.pop();
27			}
28			
29			if(s.isEmpty()) {
30				suf[i] = n;
31			}else {
32				suf[i] = s.peek();
33			}
34			s.push(i);
35		}
36		
37		long sum = 0;
38		for(int i = 0;i<arr.length;i++) {
39			long right = suf[i] - i;
40			long left = i - pre[i];
41			long cont = (right*left)%MOD;
42			long val = (arr[i]*cont)%MOD;
43			sum = (sum + val ) % MOD;
44		}
45		
46		return (int)sum;
47
48	}
49}