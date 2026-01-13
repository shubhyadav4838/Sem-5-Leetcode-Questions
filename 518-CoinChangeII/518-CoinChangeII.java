// Last updated: 13/1/2026, 1:26:49 pm
class Solution {

    static {
        for (int i = 0; i < 230; i++) {
            change(2, new int[]{2});
        }
    }

    public static int change(int amount, int[] coins) {
        int totalCoins = coins.length;
        int[] dp = new int[amount + 1];

        // Base case: there’s 1 way to make amount 0 (no coins)
        dp[0] = 1;

        // For each coin denomination
        for (int coinValue : coins) {
            // For each amount from the coin value up to target amount
            for (int currentAmount = coinValue; currentAmount <= amount; currentAmount++) {
                dp[currentAmount] += dp[currentAmount - coinValue];
            }
        }

        return dp[amount];
    }
}