// Last updated: 12/2/2026, 12:11:28 pm
1class Solution {
2    public int[] maximizeXor(int[] arr, int[][] queries) {
3        int[][] q = new int[queries.length][3];
4
5		for (int i = 0; i < q.length; i++) {
6			q[i][0] = queries[i][0]; // xi
7			q[i][1] = queries[i][1]; // mi
8			q[i][2] = i;
9		}
10
11		Arrays.sort(q, (a, b) -> a[1] - b[1]);
12		Arrays.sort(arr);
13		Trie t = new Trie();
14		int[] ans = new int[q.length];
15		
16		int j = 0;
17		for(int[] a : q) {
18			while(j<arr.length &&  arr[j]<= a[1]) {
19				t.add(arr[j]);
20				j++;
21			}
22			if(j==0) {
23				ans[a[2]] = -1;
24			}else {
25				ans[a[2]] = t.getMaxXor(a[0]);
26			}
27		}
28        return ans;
29		
30    }
31    static class Trie{
32		class Node{
33			Node zero;
34			Node one;
35		}
36		
37		private Node root = new Node();
38		
39		public void add(int val) {
40			
41			Node curr = root;
42			
43			for(int i = 31; i>=0; i--) {
44				
45				int bit = val & (1 << i);
46				
47				if(bit==0) {
48					if(curr.zero!=null) {
49						curr = curr.zero;
50					}else {
51						Node nn = new Node();
52							curr.zero = nn;
53							curr = nn;
54					}
55				}else {
56					if(curr.one!=null) {
57						curr = curr.one;
58					}else {
59						Node nn = new Node();
60							curr.one = nn;
61							curr = nn;	
62					}
63					
64				}
65			}
66		}
67		
68		public int getMaxXor(int x) {
69			int ans = 0;
70			Node curr = root;
71			for(int i = 31; i>=0; i--) {
72				int bit = x & (1<<i);
73				
74				if(bit==0) {
75					if(curr.one!=null) {
76						ans = ans | (1<<i);
77						curr = curr.one;
78					}else {
79						curr = curr.zero;
80					}
81				}else {
82					if(curr.zero != null) {
83						ans = ans | (1<<i);
84						curr = curr.zero;
85					}else {
86						curr = curr.one;
87					}
88				}
89			}
90			return ans;
91		}
92	}
93}