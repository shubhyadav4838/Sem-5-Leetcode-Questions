// Last updated: 4/8/2025, 12:00:15 am
class Solution {
    public static int candy(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            candy[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        int total = 0;
        for (int c : candy) {
            // System.out.print(c + " ");
            total += c;
        }
        return total;
    }
}
