// Last updated: 16/4/2026, 11:12:19 pm
1class Solution {
2    public static ArrayList<Integer> solveQueries(int[] arr, int[] query) {
3		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
4		for (int i = 0; i < arr.length; i++) {
5			int val = arr[i];
6			map.putIfAbsent(arr[i], new ArrayList<>());
7			map.get(val).add(i);
8		}
9		ArrayList<Integer> ll = new ArrayList<>();
10		for (int i = 0; i < query.length; i++) {
11			int idx = search(map, query[i], arr);
12			ll.add(idx);
13		}
14		return ll;
15
16	}
17
18	private static int search(HashMap<Integer, ArrayList<Integer>> map, int i, int[] arr) {
19		// TODO Auto-generated method stub
20		ArrayList<Integer> ll = map.get(arr[i]);
21		int n = arr.length;
22		if (ll.size() <= 1) {
23			return -1;
24		}
25		int target = i;
26		int lo = 0;
27		int hi = ll.size()-1;
28		int ans = -1;
29		while (lo <= hi) {
30			int mid = lo + (hi - lo) / 2;
31			if(ll.get(mid) == target ) {
32				ans = mid;
33				break;
34			}else if(ll.get(mid)>target) {
35				hi = mid-1;
36			}else {
37				lo = mid+1;
38			}
39			
40		}
41		int size = ll.size();
42		int pre = ll.get((size+ans-1)%size);
43		int post = ll.get((ans+1)%size);
44		
45		int front = Math.min(Math.abs(pre-i), n-Math.abs(pre-i));
46		int back = Math.min(Math.abs(post-i), n-Math.abs(post-i));
47		return Math.min(front,back);
48	}
49}