// Last updated: 11/6/2026, 9:59:58 am
1class Solution {
2    static HashMap<Integer,ArrayList<Integer>> map;
3    static long MOD = (long) 1e9 + 7;
4    public static int assignEdgeWeights(int[][] edges) {
5        map = new HashMap<>();
6        for(int i =1;i<=edges.length+1;i++){
7            map.put(i,new ArrayList<>());
8        }
9
10        for( int i=0;i<edges.length;i++){
11            int u = edges[i][0];
12            int v = edges[i][1];
13            map.get(u).add(v);
14            map.get(v).add(u);
15        }
16
17        int depth = maxDepth(1,-1);
18        // System.out.println(depth);
19        long ans = fastpov(2,depth-1)%MOD;
20        return (int)ans;
21    }
22
23    public static long fastpov(int a, int n){
24        if(n==0){
25            return 1;
26        }
27        if(n==1){
28            return a;
29        }
30
31        long val = fastpov(a,n/2) %MOD;
32        long res = (val * val) % MOD;
33        if(n%2==0){
34           return res;
35        }
36        return (res*a)%MOD;
37
38        
39    }
40
41    public static int maxDepth(int idx,int parent){
42        if(map.get(idx).size()==1 && map.get(idx).get(0)==parent){
43            return 0;
44        }
45        int max = 0;
46        ArrayList<Integer> ll = map.get(idx);
47        for(int i=0;i<ll.size();i++){
48            if(parent!=ll.get(i)){
49                int val = maxDepth(ll.get(i),idx);
50                max = Math.max(max,val);
51            }
52        }
53        return max+1;
54    }
55}