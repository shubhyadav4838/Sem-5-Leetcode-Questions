// Last updated: 3/8/2025, 11:56:34 pm
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int[][] diffProfit = new int[difficulty.length][2];

        for (int i = 0; i < difficulty.length; i++) {
            diffProfit[i][0] = difficulty[i];
            diffProfit[i][1] = profit[i];
        }

        Arrays.sort(diffProfit, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        // Update profits to be max so far
        int maxProfit = 0;
        int j = 0;
        int temp = 0;
        for (int i = 0; i < worker.length; i++) {
            while (j < difficulty.length && worker[i] >= diffProfit[j][0]) {
                temp = Math.max(temp, diffProfit[j][1]);
                j++;
            }
            maxProfit += temp;
        }
        return maxProfit;

        // for (int i = 0; i < difficulty.length; i++) {
        //     maxProfit = Math.max(maxProfit, diffProfit[i][1]);
        //     diffProfit[i][1] = maxProfit;
        // }

        // int totalProfit = 0;
        // for (int i = 0; i < worker.length; i++) {
        //     int index = lowerBound(diffProfit, worker[i]);
        //     if (index > -1) {
        //         totalProfit += diffProfit[index][1];
        //     }
        // }
        // return totalProfit;
    }

    private int lowerBound(int[][] diffProfit, int target) {
        int low = 0;
        int high = diffProfit.length - 1;
        int mid = 0;
        int ans = -1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (diffProfit[mid][0] > target) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;

    }
}