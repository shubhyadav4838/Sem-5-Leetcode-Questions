// Last updated: 13/7/2026, 12:19:10 pm
1class Solution {
2    static List<Integer> ll;
3    public List<Integer> sequentialDigits(int low, int high) {
4        ll = new ArrayList<>();
5        for(int i=1;i<=9;i++){
6            solve(low,high,i);
7        }
8        Collections.sort(ll);
9        return ll;
10        
11    }
12
13    public static void solve(int low, int high, long num){
14        if(num>=low && num<= high){
15            ll.add((int)num);
16        }
17        if(num>high){
18            return;
19        }
20        long base = num%10;
21        if(base<9){
22            long val = (long) (num*10)+base+1;
23            solve(low, high,val);
24
25        }
26        
27
28    }
29}