// Last updated: 25/4/2026, 10:32:22 pm
1import java.util.Arrays;
2
3class Solution {
4    public int maxDistance(int side, int[][] points, int k) {
5        int n = points.length;
6        
7        long[] p = new long[2 * n];
8
9        for (int i = 0; i < n; i++) {
10            p[i] = getPos(points[i][0], points[i][1], side);
11        }
12
13        Arrays.sort(p, 0, n);
14
15        long perimeter = 4L * side;
16        for (int i = 0; i < n; i++) {
17            p[i + n] = p[i] + perimeter;
18        }
19
20        long lo = 1;
21        long hi = perimeter / k; 
22        long ans = 0;
23
24        while (lo <= hi) {
25            long mid = lo + (hi - lo) / 2;
26            
27            if (isPossible(mid, k, p, n, perimeter)) {
28                ans = mid;
29                lo = mid + 1; 
30            } else {
31                hi = mid - 1;
32            }
33        }
34
35        return (int) ans;
36    }
37
38    private boolean isPossible(long mid, int k, long[] p, int n, long perimeter) {
39        int[] next = new int[2 * n];
40        int right = 0;
41
42        for (int left = 0; left < 2 * n; left++) {
43            while (right < 2 * n && p[right] - p[left] < mid) {
44                right++;
45            }
46            next[left] = right;
47        }
48
49        for (int i = 0; i < n; i++) {
50            int curr = i;
51            int count = 1;
52
53            while (count < k && curr < 2 * n) {
54                curr = next[curr];
55                count++;
56            }
57
58            if (curr < 2 * n && (p[i] + perimeter) - p[curr] >= mid) {
59                return true;
60            }
61        }
62        
63        return false; 
64    }
65
66    private long getPos(int x, int y, int side) {
67        if (y == 0) return x;
68        if (x == side) return (long) side + y;
69        if (y == side) return 3L * side - x;
70        return 4L * side - y;
71    }
72}