// Last updated: 27/7/2026, 11:42:49 am
class Solution {
    static HashMap<Integer,ArrayList<Integer>> map;
    static long MOD = (long) 1e9 + 7;
    public static int assignEdgeWeights(int[][] edges) {
        map = new HashMap<>();
        for(int i =1;i<=edges.length+1;i++){
            map.put(i,new ArrayList<>());
        }

        for( int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            map.get(u).add(v);
            map.get(v).add(u);
        }

        int depth = maxDepth(1,-1);
        // System.out.println(depth);
        long ans = fastpov(2,depth-1)%MOD;
        return (int)ans;
    }

    public static long fastpov(int a, int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return a;
        }

        long val = fastpov(a,n/2) %MOD;
        long res = (val * val) % MOD;
        if(n%2==0){
           return res;
        }
        return (res*a)%MOD;

        
    }

    public static int maxDepth(int idx,int parent){
        if(map.get(idx).size()==1 && map.get(idx).get(0)==parent){
            return 0;
        }
        int max = 0;
        ArrayList<Integer> ll = map.get(idx);
        for(int i=0;i<ll.size();i++){
            if(parent!=ll.get(i)){
                int val = maxDepth(ll.get(i),idx);
                max = Math.max(max,val);
            }
        }
        return max+1;
    }
}