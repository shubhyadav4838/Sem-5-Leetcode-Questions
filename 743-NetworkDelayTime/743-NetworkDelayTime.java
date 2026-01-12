// Last updated: 12/1/2026, 3:44:53 pm
1class Solution {
2   static class Pair {
3		int src;
4		int des;
5		int dis;
6
7		public Pair(int src, int des, int dis) {
8			this.src = src;
9			this.des = des;
10			this.dis = dis;
11		}
12	}
13
14	public static int minCostConnectPoints(int[][] arr) {
15		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
16		HashSet<Integer> visited = new HashSet<>();
17		pq.add(new Pair(0, 0, 0));
18		int ans = 0;
19		while (!pq.isEmpty()) {
20			Pair r = pq.poll();
21			if (visited.contains(r.src))
22				continue;
23			visited.add(r.src);
24			ans += r.dis;
25//			System.out.println(r.src + " " + r.des + " " + r.dis);
26
27			for (int j = 0; j < arr.length; j++) {
28				if (!visited.contains(j)) {
29
30					int dist = distance( j,r.src, arr);
31					pq.add(new Pair(j, r.src, dist));
32				}
33
34			}
35
36		}
37		return ans;
38
39	}
40
41	private static int distance(int i, int j, int[][] arr) {
42		// TODO Auto-generated method stub
43		return Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
44	}
45}