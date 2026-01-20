// Last updated: 20/1/2026, 6:04:50 pm
1class Solution {
2    public static int maximumLength(String s) {
3		HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
4		for(int i = 0;i<26;i++) {
5			map.put((char)(i+97), new ArrayList<>());
6		}
7		char pre = s.charAt(0);
8		int len = 1;
9		for(int i = 1; i< s.length(); i++) {
10			if(s.charAt(i)==pre) {
11				len++;
12			}else {
13				map.get(pre).add(len);
14				pre = s.charAt(i);
15				len = 1;
16			}
17		}
18		map.get(pre).add(len);
19		
20		int ans = -1;
21		for(char ch:map.keySet()) {
22			ArrayList<Integer> ll = map.get(ch);
23			if(ll.size()==0)continue;
24			int n = ll.size();
25			
26			Collections.sort(ll);
27			System.out.println(ll);
28			
29			int val = ll.get(ll.size()-1)-2;
30			if(ll.size()>=3) {
31				val = Math.max(val, ll.get(ll.size()-3));
32			}
33			if(ll.size()>=2) {
34				int num = ll.get(ll.size()-2);
35				if(ll.get(n-1)==ll.get(n-2))num--;
36				val = Math.max(val, num);
37			}
38			if(val<=0) {
39				int sum= 0;
40				for(int x:ll) {
41					sum+=x;
42				}
43				if(sum>=3)val = 1;
44			}
45			if(val>0) {
46				ans = Math.max(val, ans);
47				
48			}
49			
50		}
51		
52		
53		
54		return ans;
55
56	}
57}