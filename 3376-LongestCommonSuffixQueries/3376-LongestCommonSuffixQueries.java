// Last updated: 27/7/2026, 11:43:30 am
class Solution {
    public int[] stringIndices(String[] words, String[] arr) {
        root = new Node('*',0,-1);
		
        int minLen = Integer.MAX_VALUE;
        int minIdx = 0;
		for(int i = 0;i<words.length;i++) {
			words[i] = new StringBuilder(words[i]).reverse().toString();
            if(words[i].length() < minLen){
                minLen = words[i].length();
                minIdx = i;

            }
		}
		
		for(int i = 0;i<arr.length;i++) {
			arr[i] = new StringBuilder(arr[i]).reverse().toString();
		}
		
		for(int i = 0;i<words.length;i++) {
			addWord(words[i],i);
		}
		int[] res = new int[arr.length];
		for(int i = 0;i<arr.length;i++) {
			res[i] = search(arr[i]);
            if(res[i]==-1){
                res[i] = minIdx;
            }
		}
		
        return res;
    }

    public static int search(String s) {
		Node curr = root;
		for(int i = 0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(curr.map.containsKey(ch)) {
				curr = curr.map.get(ch);
			}else {
				return curr.idx;
			}
		}
		return curr.idx;
	}
	
	public static void addWord(String word, int idx) {
		Node curr = root;
		int n = word.length();
		for(int i = 0;i<n;i++) {
			char ch = word.charAt(i);
			if(curr.map.containsKey(ch)) {
				curr = curr.map.get(ch);
				if(curr.length>n) {
					curr.length = n;
					curr.idx = idx;
				}
			}else {
				Node temp = new Node(ch,n,idx);
				curr.map.put(ch, temp);
				curr = temp;
			}
		}	
		
	}
	
	static Node root;
	
	static class Node{
		char ch;
		HashMap<Character,Node> map;
		int length;
		int idx;
		public Node(char ch, int length, int idx) {
			this.ch = ch;
			this.length = length;
			this.idx = idx;
			this.map = new HashMap<>();
		}
		
	}
}