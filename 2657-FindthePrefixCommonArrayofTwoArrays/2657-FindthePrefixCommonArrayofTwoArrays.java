// Last updated: 20/5/2026, 10:36:14 am
1class Solution {
2    public int[] findThePrefixCommonArray(int[] a, int[] b) {
3        int n = a.length;
4        int[] pre = new int[n];
5        int[] freq = new int[n+1];
6
7        for(int i = 0;i<n; i++){
8            int left = (i==0 ? 0:pre[i-1]);
9            if(a[i]==b[i]){
10                pre[i] = left+1;
11            }else{
12                freq[a[i]]++;
13                freq[b[i]]++;
14
15                if(freq[a[i]]>1)left++;
16                if(freq[b[i]]>1)left++;
17                pre[i] = left;
18            }
19        } 
20        return pre; 
21    }
22}