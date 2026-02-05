// Last updated: 5/2/2026, 12:15:05 pm
1class Solution {
2    public String replaceWords(List<String> dictionary, String sentence) {
3        Trie t = new Trie();
4		for(String s:dictionary) {
5			t.insert(s);
6		}
7		String [] arr = sentence.split(" ");
8		StringBuilder sb = new StringBuilder();
9		for(int i = 0; i<arr.length; i++) {
10			String get = t.search(arr[i]);
11			sb.append(get+" ");
12			
13		}
14		return sb.toString().trim();
15    }
16    static class Trie {
17		class Node {
18
19			char ch;
20			String isterminal;
21			HashMap<Character, Node> child;
22
23			public Node(char ch) {
24				this.ch = ch;
25				child = new HashMap<>();
26
27			}
28
29		}
30
31		private Node root = new Node('*');
32
33		public void insert(String word) {
34			Node curr = root;
35			for (int i = 0; i < word.length(); i++) {
36				char ch = word.charAt(i);
37				if (curr.child.containsKey(ch)) {
38					curr = curr.child.get(ch);
39
40				} else {
41					Node nn = new Node(ch);
42					curr.child.put(ch, nn);
43					curr = nn;
44				}
45			}
46			curr.isterminal = word;
47		}
48		
49		public String search(String word) {
50			Node curr = root;
51			for(int i = 0; i<word.length();i++) {
52				char ch = word.charAt(i);
53				if(curr.child.containsKey(ch)) {
54					curr = curr.child.get(ch);
55					if(curr.isterminal!=null) {
56						return curr.isterminal;
57					}
58				}else {
59					return word;
60				}
61			}
62			return word;
63		}
64	}
65
66}