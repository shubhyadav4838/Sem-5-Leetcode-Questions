// Last updated: 10/1/2026, 1:50:35 pm
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
24				add(arr[i][1], arr[i][0]);
25				indegree[arr[i][0]]++;
26			
27		}
28		for(int i = 0;i<indegree.length;i++) {
29			if(indegree[i]==0) {
30				q.add(i);
31			}
32		}
33		
34		while(!q.isEmpty()) {
35			int r = q.poll();
36			ans[idx++] = r;
37			count++;
38			
39			for(int nbrs: map.get(r)) {
40				indegree[nbrs]--;
41				if(indegree[nbrs]==0) {
42					q.add(nbrs);
43				}
44			}
45		}
46		if(num!=count) {
47			return new int[0];
48		}
49		return ans;
50		
51		
52	}
53}