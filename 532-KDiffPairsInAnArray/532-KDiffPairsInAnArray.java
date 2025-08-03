// Last updated: 3/8/2025, 11:57:38 pm
class Solution {
    public int findPairs(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k < 0) return 0;

        Arrays.sort(arr);
        int n = arr.length;
        int left = 0, right = 1, count = 0;

        while (left < n && right < n) {
            if (left == right || arr[right] - arr[left] < k) {
                right++;
            } else if (arr[right] - arr[left] > k) {
                left++;
            } else {
                count++;
                int leftVal = arr[left];
                int rightVal = arr[right];
                while (left < n && arr[left] == leftVal) left++;
                while (right < n && arr[right] == rightVal) right++;
            }
        }

        return count;
    }
}