// Last updated: 1/1/2026, 6:23:49 pm
1class Solution {
2    public List<Integer> lexicalOrder(int n) {
3        ArrayList<Integer> ll = new ArrayList<>();
4        order(0,n,ll);
5        ll.remove(0);
6        return ll;
7    }
8    public static void order(int cur, int n,ArrayList<Integer>ll){
9        if(cur>n)return;
10
11        ll.add(cur);
12        int i = 0;
13        if(cur == 0){
14            i = 1;
15        }
16
17        for(;i<=9;i++){
18            order(cur*10+i,n,ll);
19        }
20    }
21}