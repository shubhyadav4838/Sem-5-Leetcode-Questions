// Last updated: 10/1/2026, 12:54:05 pm
1class Solution {
2    public static HashMap<Integer,ArrayList<Integer>> map;
3	public static void add(int e1,int e2) {
4		if(e1==e2)return;
5		map.get(e1).add(e2);
6		map.get(e2).add(e1);
7		
8	}
9
10	public static int findCircleNum(int[][] arr) {
11		map = new HashMap<>();
12		
13		for(int i = 0;i<arr.length;i++) {
14			map.put(i+1,new ArrayList<>());
15		}
16		
17		for(int i = 0;i<arr.length;i++) {
18			for(int j = 0;j<arr[0].length;j++) {
19				if(arr[i][j]==1) {
20					add(i+1,j+1);
21				}
22			}
23		}
24		int compo = 0;
25		HashSet<Integer> visited = new HashSet<>();
26		Queue<Integer> q = new LinkedList<>();
27		for(int i = 0;i<arr.length;i++) {
28			for(int j = 0;j<arr[0].length;j++) {
29				if(arr[i][j]==0 || visited.contains(i+1)) {
30					continue;
31					
32				}
33				compo++;
34				q.add(i+1);
35				while(!q.isEmpty()) {
36					int r = q.poll();
37					if(visited.contains(r))continue;
38					visited.add(r);
39					for(int nbrs:map.get(r)) {
40						if(!visited.contains(nbrs)) {
41							q.add(nbrs);
42							
43						}
44					}
45				}
46			}
47		}
48		return compo;
49		
50	}
51}