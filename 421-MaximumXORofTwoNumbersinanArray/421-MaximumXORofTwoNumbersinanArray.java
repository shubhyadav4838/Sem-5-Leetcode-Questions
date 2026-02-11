// Last updated: 11/2/2026, 12:42:57 pm
1class Solution {
2    public int findMaximumXOR(int[] arr) {
3        Trie t = new Trie();
4		for(int x:arr) {
5			t.add(x);
6		}
7		int ans = 0;
8		for(int x:arr) {
9			ans = Math.max(t.getMaxXor(x), ans);
10		}
11		
12		return ans;
13    }
14    static class Trie{
15		class Node{
16			Node zero;
17			Node one;
18		}
19		
20		private Node root = new Node();
21		
22		public void add(int val) {
23			
24			Node curr = root;
25			
26			for(int i = 31; i>=0; i--) {
27				
28				int bit = val & (1 << i);
29				
30				if(bit==0) {
31					if(curr.zero!=null) {
32						curr = curr.zero;
33					}else {
34						Node nn = new Node();
35							curr.zero = nn;
36							curr = nn;
37					}
38				}else {
39					if(curr.one!=null) {
40						curr = curr.one;
41					}else {
42						Node nn = new Node();
43							curr.one = nn;
44							curr = nn;	
45					}
46					
47				}
48			}
49		}
50		
51		public int getMaxXor(int x) {
52			int ans = 0;
53			Node curr = root;
54			for(int i = 31; i>=0; i--) {
55				int bit = x & (1<<i);
56				
57				if(bit==0) {
58					if(curr.one!=null) {
59						ans = ans | (1<<i);
60						curr = curr.one;
61					}else {
62						curr = curr.zero;
63					}
64				}else {
65					if(curr.zero != null) {
66						ans = ans | (1<<i);
67						curr = curr.zero;
68					}else {
69						curr = curr.one;
70					}
71				}
72			}
73			return ans;
74		}
75	}
76}