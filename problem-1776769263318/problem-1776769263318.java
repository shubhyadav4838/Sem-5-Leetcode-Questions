// Last updated: 21/4/2026, 4:31:03 pm
1class Solution {
2    static int[] parent;
3
4	public static int minimumHammingDistance(int[] source, int[] target, int[][] allowed) {
5		int n = source.length;
6		parent = new int[n];
7		for (int i = 0; i < n; i++) {
8			parent[i] = i;
9		}
10
11		for (int i = 0; i < allowed.length; i++) {
12			union(allowed[i][0], allowed[i][1]);
13		}
14		for (int i = 0; i < n; i++) {
15			int pi = parent[i];
16			if (parent[pi] != pi) {
17				int curr = find(i);
18				parent[pi] = curr;
19			}
20		}
21
22//		for(int x: parent) {
23//			System.out.print(x+" ");
24//		}
25//		
26		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
27		for (int i = 0; i < n; i++) {
28			map.putIfAbsent(parent[i], new HashMap<>());
29			HashMap<Integer, Integer> temp = map.get(parent[i]);
30			if (temp.containsKey(source[i])) {
31				temp.put(source[i], temp.get(source[i])+1);
32
33			} else {
34				temp.put(source[i], 1);
35			}
36		}
37
38		int ans = 0;
39		for (int i = 0; i < n; i++) {
40			map.putIfAbsent(parent[i], new HashMap<>());
41			HashMap<Integer, Integer> temp = map.get(parent[i]);
42            if(temp == null)continue;
43
44			if (temp.containsKey(target[i]) && temp.get(target[i]) > 0) {
45				temp.put(target[i], temp.get(target[i])-1);
46			} else {
47				ans++;
48			}
49		}
50
51//		System.out.println();
52		return ans;
53	}
54
55	public static int find(int i) {
56		if (parent[i] == i) {
57
58			return i;
59		}
60
61		int curr = find(parent[i]);
62		parent[i] = curr;
63		return curr;
64	}
65
66	public static void union(int i, int j) {
67		int pi = find(i);
68		int pj = find(j);
69
70		if (pi != pj) {
71			parent[pj] = pi;
72		}
73	}
74}