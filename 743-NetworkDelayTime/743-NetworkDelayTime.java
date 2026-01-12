// Last updated: 12/1/2026, 1:58:45 pm
1class Solution {
2    static HashMap<Integer,HashMap<Integer,Integer>> map;
3	public static void createMap(int n) {
4		map = new HashMap<>();
5		for(int i = 1;i<=n;i++) {
6			map.put(i,new HashMap<>());
7		}
8		
9	}
10	
11	public static void addEdge(int a, int b,int cost) {
12		map.get(a).put(b, cost);
13	}
14	
15	static class Pair{
16		int vtx;
17		int acq_vtx;
18		int cost;
19		public Pair(int vtx, int acq_vtx, int cost) {
20			this.vtx = vtx;
21			this.acq_vtx = acq_vtx;
22			this.cost = cost;
23		}
24	}
25
26	public static int networkDelayTime(int[][] arr, int n, int k) {
27		createMap(n);
28		for(int i = 0;i<arr.length;i++) {
29			addEdge(arr[i][0], arr[i][1], arr[i][2]);
30		}
31		PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
32		HashSet<Integer> visited = new HashSet<>();
33		int count = 0;
34		int ans = -1;
35		q.add(new Pair(k,k,0));
36		while(!q.isEmpty()){
37			Pair r = q.poll();
38			if(visited.contains(r.vtx)) continue;
39			visited.add(r.vtx);
40			count++;
41			
42			ans = Math.max(ans,r.cost);
43			for(int nbrs: map.get(r.vtx).keySet()) {
44				if(!visited.contains(nbrs)) {
45					int cost = map.get(r.vtx).get(nbrs) + r.cost;
46					q.add(new Pair(nbrs, r.vtx,cost ));
47				}
48			}
49			
50		}
51		if(count!=n)return -1;
52		return ans;
53		
54		
55		
56
57	}
58}