// Last updated: 22/4/2026, 1:06:43 pm
1class Solution {
2    public static ArrayList<String> twoEditWords(String[] queries, String[] dict) {
3		root = new Node('*');
4		ArrayList<String> ll = new ArrayList<>();
5		for(int i = 0;i<dict.length; i++) {
6			addWord(dict[i]);
7		}
8		
9		for(int i = 0; i<queries.length; i++) {
10			boolean present = search(queries[i], 0,root,2);
11			if(present) {
12				ll.add(queries[i]);
13			}
14		}
15		return ll;
16	}
17	
18	public static boolean search(String s, int idx, Node curr, int option) {
19		if(idx>=s.length()) {
20			return true;
21		}
22		
23		char ch = s.charAt(idx);
24		boolean present = false;
25		
26		// present
27		if(curr.map.containsKey(ch)) {
28			present = search(s,idx+1,curr.map.get(ch),option);
29		}
30		
31		// Not present
32		boolean notPresent = false;
33		if(option>0  && !present) {
34			for(Character child :curr.map.keySet()) {
35				notPresent = notPresent | search(s, idx+1, curr.map.get(child),option-1);
36			}
37		}
38		return present|notPresent;
39		
40	}
41	
42	public static void addWord(String s) {
43		Node curr = root;
44		for(int i = 0; i< s.length(); i++) {
45			char ch = s.charAt(i);
46			
47			if(curr.map.containsKey(ch)) {
48				curr = curr.map.get(ch);
49			}else {
50				Node temp = new Node(ch);
51				curr.map.put(ch,temp);
52				curr = temp;
53			}
54		}
55	}
56	
57	static Node root;
58	static class Node{
59		char ch;
60		HashMap<Character,Node> map;
61		public Node(char ch){
62			this.ch = ch;
63			this.map = new HashMap<>();
64		}
65	}
66}