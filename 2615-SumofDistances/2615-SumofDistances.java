// Last updated: 23/4/2026, 3:32:30 pm
1class Solution {
2   public static long[] distance(int[] arr) {
3		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
4		int n = arr.length;
5		long[] ans = new long[n];
6		
7		for(int i = 0; i<n; i++) {
8			map.putIfAbsent(arr[i], new ArrayList<>());
9			map.get(arr[i]).add(i);
10			
11		}
12		
13		for(int key: map.keySet()) {
14			ArrayList<Integer> ll = map.get(key);
15			int size = ll.size();
16			
17			long[] pre = new long[size];
18			pre[0] = ll.get(0);
19			for(int i = 1;i<size; i++) {
20				pre[i] =(long) pre[i-1]+ll.get(i);
21			}
22			
23			long[] suff = new long[size];
24			suff[size-1] = ll.get(size-1);
25			for(int i = size-2;i>=0; i--) {
26				suff[i] =(long) suff[i+1]+ll.get(i);
27			}
28			
29			for(int i = 0;i<size;i++) {
30				long mul = (long)i*ll.get(i);
31				
32				long front = (i==0 ? 0:(long)mul-pre[i-1]);
33				
34				long mulb = (long)ll.get(i)*(size-i-1);
35				long back = (i==size-1 ? 0 :(long)suff[i+1]-mulb);
36				
37				long total = (long)front+back;
38				ans[ll.get(i)] = total;
39			}
40		}
41		return ans;
42
43	}
44
45}