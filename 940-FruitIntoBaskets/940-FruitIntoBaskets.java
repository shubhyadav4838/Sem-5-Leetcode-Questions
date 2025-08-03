// Last updated: 3/8/2025, 11:56:17 pm
class Solution {
    public int totalFruit(int[] fruits) {
        return CountFruit(fruits);
    }

    public static int CountFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }

        int i = 0;
        int ans = 0;
        int lastFruit = -1, secondLastFruit = -1;
        int lastFruitCount = 0; 
        for (int j = 0; j < fruits.length; j++) {
            if (fruits[j] == lastFruit || fruits[j] == secondLastFruit) {
            } else {
                i = j - lastFruitCount;
                secondLastFruit = lastFruit;
            }

            if (fruits[j] == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruits[j];
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}
