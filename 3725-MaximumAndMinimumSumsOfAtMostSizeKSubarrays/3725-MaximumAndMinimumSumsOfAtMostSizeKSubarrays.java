// Last updated: 27/7/2026, 11:43:04 am
import java.util.Stack;

class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long totalSum = 0;
        
        int[] prevMin = new int[n];
        int[] nextMin = new int[n];
        getRanges(nums, prevMin, nextMin, true);

        int[] prevMax = new int[n];
        int[] nextMax = new int[n];
        getRanges(nums, prevMax, nextMax, false); 

        for (int i = 0; i < n; i++) {
           
            long leftMin = i - prevMin[i];
            long rightMin = nextMin[i] - i;
            long countMin = countValidSubarrays(leftMin, rightMin, k);

            long leftMax = i - prevMax[i];
            long rightMax = nextMax[i] - i;
            long countMax = countValidSubarrays(leftMax, rightMax, k);

            long val = nums[i];
            
            totalSum += val * (countMax + countMin);
        }

        return totalSum;
    }

    private void getRanges(int[] nums, int[] prev, int[] next, boolean isMin) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

     
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty()) {
                if (isMin) {
                    if (nums[st.peek()] >= nums[i]) st.pop();
                    else break;
                } else {
                    if (nums[st.peek()] <= nums[i]) st.pop();
                    else break;
                }
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

    
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty()) {
                if (isMin) {
                    if (nums[st.peek()] > nums[i]) st.pop(); 
                    else break;
                } else {
                    if (nums[st.peek()] < nums[i]) st.pop(); 
                    else break;
                }
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

     private long countValidSubarrays(long L, long R, int k) {
       
        if (L <= 0 || R <= 0 || k <= 0) return 0L;
        
        long t = k;
        long maxAll = L + R - 1;
        
        if (t >= maxAll) return L * R;
        
        long A = t + 1 - R;
        
        if (A < 0) A = 0;
        if (A > L) A = L;
        long total = R * A;
        
        long L2 = (L < t) ? L : t;
        long count = L2 - A;
        
        if (count > 0) {
            total += count * (2 * t + 1 - A - L2) / 2;
        }
        
        return total;
    }
}