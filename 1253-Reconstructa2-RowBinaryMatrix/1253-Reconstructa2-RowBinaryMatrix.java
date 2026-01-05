// Last updated: 5/1/2026, 7:12:28 pm
1class Solution {
2    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
3        List<Integer> a = new ArrayList<>();
4		List<Integer> b = new ArrayList<>();
5		List<List<Integer>> res = new ArrayList<>();
6		int[] up = new int[colsum.length];
7		int[] lo = new int[colsum.length];
8		
9		for(int i = 0;i<colsum.length;i++) {
10			int val = colsum[i];
11			if(val==1)continue;
12			if(val==2) {
13				up[i] = 1;
14				lo[i] = 1;
15				upper--;
16				lower--;
17			}
18		}
19		
20		for(int i = 0;i<colsum.length;i++) {
21			int val = colsum[i];
22			if(val!=1)continue;
23			if(upper>0) {
24				up[i] = 1;
25				upper--;
26			}else {
27				lo[i] = 1;
28				lower--;
29			}
30		}
31		if(upper ==0 && lower==0) {
32			for(int i = 0;i<up.length;i++) {
33				a.add(up[i]);
34				b.add(lo[i]);
35			}
36			res.add(a);
37			res.add(b);
38		}
39		return res;
40    }
41}