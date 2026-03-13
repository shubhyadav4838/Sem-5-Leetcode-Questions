// Last updated: 13/3/2026, 3:58:16 pm
1class Solution {
2    public static List<Integer> countSmaller(int[] arr) {
3	    int n = arr.length;
4	    int[][] res = new int[n][2];
5	    
6	    for(int i = 0; i < n; i++) {
7	        res[i][0] = arr[i];
8	        res[i][1] = i + 1;
9	    }
10	    
11	    Arrays.sort(res, (a, b) -> {
12	        if (a[0] == b[0]) return a[1] - b[1];
13	        return a[0] - b[0];
14	    });
15	    
16	    int[] bit = new int[n + 1];
17	    int[] ans = new int[n];
18	    
19	    for(int i = 0; i < n; i++) {
20	        int originalIdx = res[i][1];
21	        int ed = i;
22	        int st = query(originalIdx, bit);
23	        
24	        ans[originalIdx - 1] = ed - st;
25	        update(originalIdx, 1, n, bit);
26	    }
27	    
28	    List<Integer> list = new ArrayList<>();
29	    for(int val : ans) {
30	        list.add(val);
31	    }
32	    
33	    return list;
34	}
35
36	public static int query(int id, int[] bit) {
37	    int ans = 0;
38	    while(id > 0) {
39	        ans += bit[id];
40	        id -= (id & -id);
41	    }
42	    return ans;
43	}
44
45	public static void update(int id, int val, int n, int[] bit) {
46	    while(id <= n) {
47	        bit[id] += val;
48	        id += (id & -id);
49	    }
50	}
51}