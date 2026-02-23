// Last updated: 23/2/2026, 4:19:48 pm
1class Solution {
2    public int minimumTotal(List<List<Integer>> ll) {
3        for(int i = 1; i < ll.size() ; i++ ){
4            for(int j = 0;j<ll.get(i).size();j++){
5                int a = Integer.MAX_VALUE;
6                int b = Integer.MAX_VALUE;
7                if( j!=0 ){
8                    a = ll.get(i-1).get(j-1);
9                }
10                if(j<ll.get(i-1).size()){
11                    b = ll.get(i-1).get(j);
12                }
13                int val = Math.min(a,b)+ll.get(i).get(j);
14                ll.get(i).set(j,val);
15            }
16        }
17        int ans = Integer.MAX_VALUE;
18        int last = ll.size()-1;
19        for(int i =0 ; i<ll.get(last).size();i++){
20            ans = Math.min(ans,ll.get(last).get(i));
21        } 
22        return ans;
23    }
24}