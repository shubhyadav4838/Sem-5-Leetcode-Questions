// Last updated: 10/3/2026, 11:19:58 am
1class Solution {
2    public int longestStrChain(String[] arr) {
3        int n = arr.length;
4        Arrays.sort(arr,(a,b)->a.length()-b.length());
5        int[] dp = new int[n];
6
7        Arrays.fill(dp,1);
8        int maxlen = 1;
9        for(int i = 0; i<n; i++){
10            for(int j = 0; j<i; j++){
11                if(ispossible(arr[j],arr[i]) && dp[i]<dp[j]+1){
12                    dp[i] = dp[j]+1;
13                }
14
15                maxlen = Math.max(maxlen,dp[i]);
16            }
17        }
18        return maxlen;
19    }
20
21    public static boolean ispossible(String a, String b){
22        int n = a.length();
23        int m = b.length();
24        if(n+1 != m)return false;
25        int idxa = 0;
26        int idxb = 0;
27        int count = 0;
28        while(idxa<n && idxb<m){
29            if(a.charAt(idxa)==b.charAt(idxb)){
30                idxa++;
31                idxb++;
32                count++;
33            }else{
34                idxb++;
35            }
36        }
37        return count==n;
38        
39    }
40}