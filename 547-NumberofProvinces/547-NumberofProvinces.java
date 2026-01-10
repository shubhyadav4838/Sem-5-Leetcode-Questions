// Last updated: 10/1/2026, 1:45:14 pm
1class Solution {
2    public static HashMap<Integer, ArrayList<Integer>> map;
3
4	public static void add(int e1, int e2) {
5		if (e1 == e2)
6			return;
7		map.get(e1).add(e2);
8
9	}
10
11	public static int[] findOrder(int num, int[][] arr) {
12		map = new HashMap<>();
13		for (int i = 0; i < num; i++) {
14			map.put(i, new ArrayList<>());
15		}
16
17		int[] indegree = new int[num];
18		Queue<Integer> q = new LinkedList<>();
19		int count = 0;
20		int[] ans = new int[num];
21		int idx = 0;
22		
23		for (int i = 0; i < arr.length; i++) {
24			for (int j = 0; j < arr[0].length; j++) {
25				add(arr[i][1], arr[i][0]);
26				indegree[arr[i][0]]++;
27			}
28		}
29		for(int i = 0;i<indegree.length;i++) {
30			if(indegree[i]==0) {
31				q.add(i);
32			}
33		}
34		
35		while(!q.isEmpty()) {
36			int r = q.poll();
37			ans[idx++] = r;
38			count++;
39			
40			for(int nbrs: map.get(r)) {
41				indegree[nbrs]--;
42				if(indegree[nbrs]==0) {
43					q.add(nbrs);
44				}
45			}
46		}
47		if(num!=count) {
48			return new int[0];
49		}
50		return ans;
51		
52		
53	}
54}