// Last updated: 27/7/2026, 11:44:28 am

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            int sz = 0;
            int lSum = 0;
            int rSum = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sz++;
                    lSum += nums[i];
                    rSum += nums[i + n];
                }
            }
            left[sz].add(lSum);
            right[sz].add(rSum);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }

        int minDiff = Integer.MAX_VALUE;
        int targetSum = totalSum / 2;

        for (int i = 0; i <= n; i++) {
            List<Integer> rList = right[n - i];
            
            for (int a : left[i]) {
                int bTarget = targetSum - a;
                
                int low = 0;
                int high = rList.size() - 1;
                
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (rList.get(mid) == bTarget) {
                        low = mid;
                        break;
                    } else if (rList.get(mid) < bTarget) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                
                int pos = low;
                
                if (pos < rList.size()) {
                    int b = rList.get(pos);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
                }
                
                if (pos > 0) {
                    int b = rList.get(pos - 1);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (a + b)));
                }
            }
        }

        return minDiff;
    }
}