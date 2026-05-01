// Last updated: 1/5/2026, 10:10:02 pm
1class Solution {
2    public int maxRotateFunction(int[] A) {
3        int sum = 0, F = 0;
4        int n = A.length;
5
6        for (int i = 0; i < n; i++) {
7            sum += A[i];
8            F += i * A[i];
9        }
10
11        int max = F;
12
13        for (int i = 1; i < n; i++) {
14            F += sum - n * A[n - i];
15            max = Math.max(max, F);
16        }
17
18        return max;
19    }
20}