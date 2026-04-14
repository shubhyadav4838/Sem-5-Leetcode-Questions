// Last updated: 15/4/2026, 12:25:09 am
1import java.util.*;
2
3class Solution {
4    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
5        Collections.sort(robot);
6        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
7        
8        long[][] memo = new long[robot.size()][factory.length];
9        for (long[] row : memo) {
10            Arrays.fill(row, -1);
11        }
12        
13        return solve(0, 0, robot, factory, memo);
14    }
15    
16    public static long solve(int ri, int fi, List<Integer> robot, int[][] factory, long[][] memo) {
17        if (ri == robot.size()) return 0;
18        
19        if (fi == factory.length) return 1_000_000_000_000L; 
20        
21        if (memo[ri][fi] != -1) return memo[ri][fi];
22        
23        long ans = solve(ri, fi + 1, robot, factory, memo);
24        
25        long currDis = 0;
26        int limit = factory[fi][1];
27        int factoryPos = factory[fi][0];
28        
29        for (int k = 1; k <= limit && ri + k - 1 < robot.size(); k++) {
30            currDis += Math.abs(robot.get(ri + k - 1) - factoryPos);
31            long next = solve(ri + k, fi + 1, robot, factory, memo); 
32            ans = Math.min(ans, currDis + next);
33        }
34        
35        return memo[ri][fi] = ans;
36    }
37}