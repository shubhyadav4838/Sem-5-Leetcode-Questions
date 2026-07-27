// Last updated: 27/7/2026, 11:42:53 am
class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        
        long[] p = new long[2 * n];

        for (int i = 0; i < n; i++) {
            p[i] = getPos(points[i][0], points[i][1], side);
        }

        Arrays.sort(p, 0, n);

        long perimeter = 4L * side;
        for (int i = 0; i < n; i++) {
            p[i + n] = p[i] + perimeter;
        }

        long lo = 1;
        long hi = perimeter / k; 
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            
            if (isPossible(mid, k, p, n, perimeter)) {
                ans = mid;
                lo = mid + 1; 
            } else {
                hi = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean isPossible(long mid, int k, long[] p, int n, long perimeter) {
        int[] next = new int[2 * n];
        int right = 0;

        for (int left = 0; left < 2 * n; left++) {
            while (right < 2 * n && p[right] - p[left] < mid) {
                right++;
            }
            next[left] = right;
        }

        for (int i = 0; i < n; i++) {
            int curr = i;
            int count = 1;

            while (count < k && curr < 2 * n) {
                curr = next[curr];
                count++;
            }

            if (curr < 2 * n && (p[i] + perimeter) - p[curr] >= mid) {
                return true;
            }
        }
        
        return false; 
    }

    private long getPos(int x, int y, int side) {
        if (y == 0) return x;
        if (x == side) return (long) side + y;
        if (y == side) return 3L * side - x;
        return 4L * side - y;
    }
}