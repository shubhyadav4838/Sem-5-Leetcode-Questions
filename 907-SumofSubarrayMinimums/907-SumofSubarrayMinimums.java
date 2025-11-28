// Last updated: 29/11/2025, 1:49:09 am
1class Solution {
2    public int sumSubarrayMins(int[] arr) {
3        return subMin(arr);
4    }
5   public static int subMin(int[] arr) {
6        int n = arr.length;
7        int[] pre = new int[n];
8        int[] suff = new int[n];
9        Stack<Integer> p = new Stack<>();
10        Stack<Integer> s = new Stack<>();
11        
12        long MOD = (long)(1e9 + 7); 
13
14        for(int i = 0; i < n; i++) {
15            while(!p.isEmpty() && arr[p.peek()] >= arr[i]) {
16                p.pop();
17            }
18            if(p.isEmpty()) {
19                pre[i] = -1;
20            } else {
21                pre[i] = p.peek();
22            }
23            p.push(i);
24        }
25        
26        for(int i = n - 1; i >= 0; i--) {
27            while(!s.isEmpty() && arr[s.peek()] > arr[i]) {
28                s.pop();
29            }
30            if(s.isEmpty()) {
31                suff[i] = n;
32            } else {
33                suff[i] = s.peek();
34            }
35            s.push(i);
36        }
37        
38        long sum = 0; 
39        for(int i = 0; i < n; i++) {
40            long leftCount = i - pre[i];
41            long rightCount = suff[i] - i;
42            long totalSubarrays = (leftCount * rightCount) % MOD;  
43            long contribution = (arr[i] * totalSubarrays) % MOD;
44            
45            sum = (sum + contribution) % MOD;
46        }
47        
48        return (int) sum;
49    }
50}