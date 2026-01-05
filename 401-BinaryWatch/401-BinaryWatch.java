// Last updated: 6/1/2026, 1:30:47 am
1class Solution {
2   public static List<String> readBinaryWatch(int turnedOn) {
3		int[] hr = {1,2,4,8};
4		int[] min = {1,2,4,8,16,32};
5		List<String> ll = new ArrayList<>();
6		if(turnedOn==0) {
7            ll.add("0:00");
8			return ll;
9		}
10		
11		solve(min,hr,0,0,0,ll,turnedOn);		
12		
13		return ll;
14		
15	}
16
17	private static void solve(int[] min, int[] hr, int chr, int cmin,int idx,List<String> ll,int turn) {
18		// TODO Auto-generated method stub
19		if(chr>=12 || cmin>=60)return;
20		if(turn==0) {
21			String s = ""+chr+":";
22			if(cmin<10) {
23				s = s+"0"+cmin;
24			}else {
25				s = s+cmin;
26			}
27			ll.add(s);
28		}
29		
30		for(int i = idx;i<10;i++) {
31			if(i<4) {
32				solve(min,hr,chr+hr[i],cmin,i+1,ll,turn-1);
33				
34			}else {
35				solve(min,hr,chr,cmin+min[i-4],i+1,ll,turn-1);
36			}
37		}
38		
39		
40	}
41}