// Last updated: 5/2/2026, 12:55:46 pm
1class Solution {
2    static List<String> ll ;
3    public List<String> findWords(char[][] maze, String[] words) {
4        ll = new ArrayList<>();
5		Trie t = new Trie();
6		for (String s : words) {
7			t.insert(s);
8		}
9		for (int i = 0; i < maze.length; i++) {
10			for (int j = 0; j < maze[0].length; j++) {
11				if (t.root.child.containsKey(maze[i][j])) {
12					t.Search(maze, i, j, t.root);
13				}
14			}
15		}
16        return ll;
17    }
18    static class Trie {
19		class Node {
20
21			char ch;
22			String isterminal;
23			HashMap<Character, Node> child;
24
25			public Node(char ch) {
26				this.ch = ch;
27				child = new HashMap<>();
28
29			}
30
31		}
32
33		private Node root = new Node('*');
34
35		public void insert(String word) {
36			Node curr = root;
37			for (int i = 0; i < word.length(); i++) {
38				char ch = word.charAt(i);
39				if (curr.child.containsKey(ch)) {
40					curr = curr.child.get(ch);
41
42				} else {
43					Node nn = new Node(ch);
44					curr.child.put(ch, nn);
45					curr = nn;
46				}
47			}
48			curr.isterminal = word;
49		}
50
51		public void Search(char[][] maze, int i, int j, Node node) {
52			// TODO Auto-generated method stub
53			if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || !node.child.containsKey(maze[i][j])) {
54				return;
55			}
56			char ch = maze[i][j];
57			node = node.child.get(ch);
58			if(node.isterminal!=null) {
59				ll.add(node.isterminal);
60				node.isterminal = null; // ek terminal se ek hi word milega
61			}
62			maze[i][j] = '*';
63			Search(maze, i + 1, j, node);
64			Search(maze, i - 1, j, node);
65			Search(maze, i, j + 1, node);
66			Search(maze, i, j - 1, node);
67
68			maze[i][j] = ch;
69
70		}
71
72		public String search(String word) {
73			Node curr = root;
74			for (int i = 0; i < word.length(); i++) {
75				char ch = word.charAt(i);
76				if (curr.child.containsKey(ch)) {
77					curr = curr.child.get(ch);
78					if (curr.isterminal != null) {
79						return curr.isterminal;
80					}
81				} else {
82					return word;
83				}
84			}
85			return word;
86		}
87	}
88}