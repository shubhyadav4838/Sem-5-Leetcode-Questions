// Last updated: 27/7/2026, 11:43:57 am
class Solution {
    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        
        long[][] memo = new long[robot.size()][factory.length];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, robot, factory, memo);
    }
    
    public static long solve(int ri, int fi, List<Integer> robot, int[][] factory, long[][] memo) {
        if (ri == robot.size()) return 0;
        
        if (fi == factory.length) return 1_000_000_000_000L; 
        
        if (memo[ri][fi] != -1) return memo[ri][fi];
        
        long ans = solve(ri, fi + 1, robot, factory, memo);
        
        long currDis = 0;
        int limit = factory[fi][1];
        int factoryPos = factory[fi][0];
        
        for (int k = 1; k <= limit && ri + k - 1 < robot.size(); k++) {
            currDis += Math.abs(robot.get(ri + k - 1) - factoryPos);
            long next = solve(ri + k, fi + 1, robot, factory, memo); 
            ans = Math.min(ans, currDis + next);
        }
        
        return memo[ri][fi] = ans;
    }
}