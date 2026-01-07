// Last updated: 7/1/2026, 11:14:33 pm
1class Solution {
2    public static boolean wordBreak(String s, List<String> ll) {
3		HashSet<String> set = new HashSet<>();
4		for(String k:ll) {
5			set.add(k);
6		}
7		int[] visited = new int[s.length()+1];
8		return solve(s,set,0,visited);
9	}
10
11	private static boolean solve(String s, HashSet<String> set, int idx, int[] visited) {
12		// TODO Auto-generated method stub
13		if(idx==s.length()) {
14			return true;
15		}
16		
17		if(visited[idx]==1) {
18			return true;
19		}else if(visited[idx]==-1) {
20			return false;
21		}
22		boolean ans = false;
23		for(int i= idx;i<=s.length();i++) {
24			if(set.contains(s.substring(idx,i))) {
25				ans = solve(s,set,i,visited);
26			}
27			if(ans) {
28				visited[idx] = 1;
29				return true;
30				
31			}else {
32				visited[idx] = -1;
33			}
34				
35			
36		}
37		visited[idx] = -1;
38		return false;
39		
40	}
41}