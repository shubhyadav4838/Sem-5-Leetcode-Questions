// Last updated: 15/4/2026, 12:29:09 am
1class Solution {
2    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
3        Collections.sort(robot);
4        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
5        
6        long[][] memo = new long[robot.size()][factory.length];
7        for (long[] row : memo) {
8            Arrays.fill(row, -1);
9        }
10        
11        return solve(0, 0, robot, factory, memo);
12    }
13    
14    public static long solve(int ri, int fi, List<Integer> robot, int[][] factory, long[][] memo) {
15        if (ri == robot.size()) return 0;
16        
17        if (fi == factory.length) return 1_000_000_000_000L; 
18        
19        if (memo[ri][fi] != -1) return memo[ri][fi];
20        
21        long ans = solve(ri, fi + 1, robot, factory, memo);
22        
23        long currDis = 0;
24        int limit = factory[fi][1];
25        int factoryPos = factory[fi][0];
26        
27        for (int k = 1; k <= limit && ri + k - 1 < robot.size(); k++) {
28            currDis += Math.abs(robot.get(ri + k - 1) - factoryPos);
29            long next = solve(ri + k, fi + 1, robot, factory, memo); 
30            ans = Math.min(ans, currDis + next);
31        }
32        
33        return memo[ri][fi] = ans;
34    }
35}