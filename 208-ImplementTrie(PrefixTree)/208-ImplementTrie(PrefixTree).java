// Last updated: 4/2/2026, 12:20:09 pm
1class Trie {
2
3    class Node {
4		char ch;
5		boolean isterminal;
6		HashMap<Character, Node> child;
7
8		public Node(char ch) {
9			this.ch = ch;
10			child = new HashMap<>();
11		}
12	}
13
14	private Node root;
15
16	public Trie() {
17		root = new Node('*');
18	}
19
20	public void insert(String word) {
21		Node curr = root;
22		for (int i = 0; i < word.length(); i++) {
23			char ch = word.charAt(i);
24			if (curr.child.containsKey(ch)) {
25				curr = curr.child.get(ch);
26			} else {
27				Node nn = new Node(ch);
28				curr.child.put(ch, nn);
29				curr = nn;
30			}
31		}
32		curr.isterminal = true;
33	}
34
35	public boolean search(String word) {
36		Node curr = root;
37		for (int i = 0; i < word.length(); i++) {
38			char ch = word.charAt(i);
39			if (curr.child.containsKey(ch)) {
40				curr = curr.child.get(ch);
41			} else {
42				return false;
43			}
44		}
45		return curr.isterminal;
46	}
47
48	public boolean startsWith(String word) {
49
50		Node curr = root;
51		for (int i = 0; i < word.length(); i++) {
52			char ch = word.charAt(i);
53			if (curr.child.containsKey(ch)) {
54				curr = curr.child.get(ch);
55			} else {
56				return false;
57			}
58		}
59		return true;
60	}
61
62}
63
64/**
65 * Your Trie object will be instantiated and called as such:
66 * Trie obj = new Trie();
67 * obj.insert(word);
68 * boolean param_2 = obj.search(word);
69 * boolean param_3 = obj.startsWith(prefix);
70 */