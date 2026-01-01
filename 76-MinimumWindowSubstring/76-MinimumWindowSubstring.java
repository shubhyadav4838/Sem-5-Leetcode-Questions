// Last updated: 1/1/2026, 3:58:01 pm
1class Solution {
2    public String minWindow(String s, String t) {
3        return minstring(s,t);
4    }
5    public static String minstring(String s, String t) {
6		HashMap<Character,Integer> mapt = new HashMap<>();
7		HashMap<Character,Integer> maps = new HashMap<>();
8		int countt = 0;
9		int counts = 0;
10		String ans = "";
11		
12		for(int i = 0;i<t.length();i++) {
13			countt++;
14			char ch = t.charAt(i);
15			if(!mapt.containsKey(ch))mapt.put(ch, 0);
16			mapt.put(ch, mapt.get(ch)+1);
17		}
18		
19		int st = 0;
20		int ed = 0;
21		
22		while(ed<s.length() && counts<countt) {
23			char ch = s.charAt(ed);
24			if(mapt.containsKey(ch)) {
25				if(!maps.containsKey(ch))maps.put(ch, 0);
26				maps.put(ch, maps.get(ch)+1);
27				
28				if(maps.get(ch)<=mapt.get(ch))counts++;
29			}
30			ed++;
31		}
32		// System.out.println(ed+" "+counts+" "+countt);
33		if(counts<countt)return ans;
34		
35		while(st<ed) {
36			char ch = s.charAt(st);
37			if(mapt.containsKey(ch) ) {
38				if(maps.get(ch)<=mapt.get(ch))break;
39				if(maps.get(ch)>mapt.get(ch)) maps.put(ch, maps.get(ch)-1);
40			}
41			st++;
42		}
43		ans = s.substring(st,ed);
44		
45		while(ed<s.length() && st<ed) {
46			char end = s.charAt(ed);
47			if(s.charAt(st)==s.charAt(ed)) {
48				maps.put(s.charAt(st), maps.get(s.charAt(st))+1);
49				while(st<ed) {
50					if(ed-st+1<ans.length()) {
51						ans = s.substring(st,ed+1);
52					}
53					char start =s.charAt(st);
54					if(!mapt.containsKey(start))st++;
55					else if(maps.containsKey(start) && maps.get(start)>mapt.get(start)){
56						maps.put(start, maps.get(start)-1);
57						st++;
58					}else break;
59				}
60				// System.out.println(st+" "+ed);
61			
62			}else if(mapt.containsKey(end)) {
63				maps.put(end,maps.get(end)+1);
64			}
65			ed++;
66		}
67		// System.out.println(st+" "+ed);
68		return ans;
69				
70	}
71}