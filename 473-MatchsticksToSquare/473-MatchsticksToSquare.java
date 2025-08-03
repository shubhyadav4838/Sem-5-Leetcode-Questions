// Last updated: 3/8/2025, 11:57:53 pm
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int stick : matchsticks) {
            total += stick;
        }

        if (total % 4 != 0) return false;
        int side = total / 4;

        Arrays.sort(matchsticks);
        reverse(matchsticks); 

        int[] sides = new int[4];

        return backtrack(matchsticks, sides, 0, side);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            for (int i = 0; i < 4; i++) {
                if (sides[i] != target) return false;
            }
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= target) {
                sides[i] += matchsticks[index];
                if (backtrack(matchsticks, sides, index + 1, target)) return true;
                sides[i] -= matchsticks[index];
            }
        }

        return false;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
