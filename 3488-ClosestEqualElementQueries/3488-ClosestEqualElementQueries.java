// Last updated: 16/4/2026, 11:02:12 pm
1class Solution {
2    public static ArrayList<Integer> solveQueries(int[] arr, int[] query) {
3		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
4		for (int i = 0; i < arr.length; i++) {
5			int val = arr[i];
6			map.putIfAbsent(arr[i], new ArrayList<>());
7			map.get(val).add(i);
8		}
9		System.out.println(map);
10
11		ArrayList<Integer> ll = new ArrayList<>();
12		for (int i = 0; i < query.length; i++) {
13			int idx = search(map, query[i], arr);
14			ll.add(idx);
15		}
16		return ll;
17
18	}
19
20	private static int search(HashMap<Integer, ArrayList<Integer>> map, int i, int[] arr) {
21		// TODO Auto-generated method stub
22		ArrayList<Integer> ll = map.get(arr[i]);
23		int n = arr.length;
24		if (ll.size() == 1) {
25			return -1;
26		}
27		int target = i;
28		int lo = 0;
29		int hi = ll.size()-1;
30		int ans = -1;
31		while (lo <= hi) {
32			int mid = lo + (hi - lo) / 2;
33			if(ll.get(mid) == target ) {
34				ans = mid;
35				break;
36			}else if(ll.get(mid)>target) {
37				hi = mid-1;
38			}else {
39				lo = mid+1;
40			}
41			
42		}
43		int size = ll.size();
44		int pre = (size+ans-1)%size;
45		int post = (ans+1)%size;
46		int front = Math.min(Math.abs(ll.get(ans)-ll.get(pre)), Math.abs(ll.get(post)-ll.get(ans)));
47		int back = Integer.MAX_VALUE;
48		if(ll.get(pre)<i) {
49			int val = ll.get(pre)+n-i;
50			back = Math.min(val, back);
51		}else {
52			int val = i+n-ll.get(pre);
53			back = Math.min(val, back);
54		}
55		
56		if(ll.get(post)>i) {
57			int val = n-ll.get(post)+i;
58			back = Math.min(val, back);
59		}else {
60			int val = n-i+ll.get(post);
61			back = Math.min(val, back);
62		}
63		return Math.min(front,back);
64	}
65}