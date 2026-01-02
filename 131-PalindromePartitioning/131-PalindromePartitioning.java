// Last updated: 3/1/2026, 12:49:00 am
1class Solution {
2    public List<List<String>> partition(String s) {
3        Scanner sc = new Scanner(System.in);
4		List<String> ll = new ArrayList<>();
5		List<List<String>> ans = new ArrayList<>();
6		partition(s, ans, ll);
7        return ans;
8    }
9    private static void partition(String ques, List<List<String>> res, List<String> ll) {
10		// TODO Auto-generated method stub
11		if(ques.length()==0) {
12			res.add(new ArrayList<>(ll));
13			return;
14		}
15		
16		for(int i = 0; i<ques.length();i++) {
17			String sub = ques.substring(0,i+1);
18			if(isPalindrome(sub)) {
19				ll.add(sub);
20				partition(ques.substring(i+1),res,ll);
21				ll.remove(ll.size()-1);
22			}
23		}
24		
25		
26
27	}
28	public static boolean isPalindrome(String s) {
29		if(s.length()==1)return true;
30		int si = 0;
31		int ei = s.length()-1;
32		while(si<ei) {
33			if(s.charAt(si)!=s.charAt(ei))return false;
34			si++;
35			ei--;
36		}
37		return true;
38	}
39}