// Last updated: 28/5/2026, 12:53:31 pm
1class Solution {
2    public int[] stringIndices(String[] words, String[] arr) {
3        root = new Node('*',0,-1);
4		
5        int minLen = Integer.MAX_VALUE;
6        int minIdx = 0;
7		for(int i = 0;i<words.length;i++) {
8			words[i] = new StringBuilder(words[i]).reverse().toString();
9            if(words[i].length() < minLen){
10                minLen = words[i].length();
11                minIdx = i;
12
13            }
14		}
15		
16		for(int i = 0;i<arr.length;i++) {
17			arr[i] = new StringBuilder(arr[i]).reverse().toString();
18		}
19		
20		for(int i = 0;i<words.length;i++) {
21			addWord(words[i],i);
22		}
23		int[] res = new int[arr.length];
24		for(int i = 0;i<arr.length;i++) {
25			res[i] = search(arr[i]);
26            if(res[i]==-1){
27                res[i] = minIdx;
28            }
29		}
30		
31        return res;
32    }
33
34    public static int search(String s) {
35		Node curr = root;
36		for(int i = 0;i<s.length();i++) {
37			char ch = s.charAt(i);
38			if(curr.map.containsKey(ch)) {
39				curr = curr.map.get(ch);
40			}else {
41				return curr.idx;
42			}
43		}
44		return curr.idx;
45	}
46	
47	public static void addWord(String word, int idx) {
48		Node curr = root;
49		int n = word.length();
50		for(int i = 0;i<n;i++) {
51			char ch = word.charAt(i);
52			if(curr.map.containsKey(ch)) {
53				curr = curr.map.get(ch);
54				if(curr.length>n) {
55					curr.length = n;
56					curr.idx = idx;
57				}
58			}else {
59				Node temp = new Node(ch,n,idx);
60				curr.map.put(ch, temp);
61				curr = temp;
62			}
63		}	
64		
65	}
66	
67	static Node root;
68	
69	static class Node{
70		char ch;
71		HashMap<Character,Node> map;
72		int length;
73		int idx;
74		public Node(char ch, int length, int idx) {
75			this.ch = ch;
76			this.length = length;
77			this.idx = idx;
78			this.map = new HashMap<>();
79		}
80		
81	}
82}