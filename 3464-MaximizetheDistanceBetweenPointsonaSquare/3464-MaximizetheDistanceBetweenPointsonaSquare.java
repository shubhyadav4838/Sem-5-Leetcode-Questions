// Last updated: 25/4/2026, 10:32:32 pm
1class Solution {
2    public int maxDistance(int side, int[][] points, int k) {
3        int n = points.length;
4        
5        long[] p = new long[2 * n];
6
7        for (int i = 0; i < n; i++) {
8            p[i] = getPos(points[i][0], points[i][1], side);
9        }
10
11        Arrays.sort(p, 0, n);
12
13        long perimeter = 4L * side;
14        for (int i = 0; i < n; i++) {
15            p[i + n] = p[i] + perimeter;
16        }
17
18        long lo = 1;
19        long hi = perimeter / k; 
20        long ans = 0;
21
22        while (lo <= hi) {
23            long mid = lo + (hi - lo) / 2;
24            
25            if (isPossible(mid, k, p, n, perimeter)) {
26                ans = mid;
27                lo = mid + 1; 
28            } else {
29                hi = mid - 1;
30            }
31        }
32
33        return (int) ans;
34    }
35
36    private boolean isPossible(long mid, int k, long[] p, int n, long perimeter) {
37        int[] next = new int[2 * n];
38        int right = 0;
39
40        for (int left = 0; left < 2 * n; left++) {
41            while (right < 2 * n && p[right] - p[left] < mid) {
42                right++;
43            }
44            next[left] = right;
45        }
46
47        for (int i = 0; i < n; i++) {
48            int curr = i;
49            int count = 1;
50
51            while (count < k && curr < 2 * n) {
52                curr = next[curr];
53                count++;
54            }
55
56            if (curr < 2 * n && (p[i] + perimeter) - p[curr] >= mid) {
57                return true;
58            }
59        }
60        
61        return false; 
62    }
63
64    private long getPos(int x, int y, int side) {
65        if (y == 0) return x;
66        if (x == side) return (long) side + y;
67        if (y == side) return 3L * side - x;
68        return 4L * side - y;
69    }
70}