// Last updated: 3/8/2025, 11:54:43 pm
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        return ShortestSubarray(arr);
        
    }
   public static int ShortestSubarray(int[] arr) { 
    if (checkReversed(arr)) {
        return arr.length - 1;
    }

    int lo = 0, hi = arr.length - 1;

    while (lo < arr.length - 1 && arr[lo] <= arr[lo + 1]) {
        lo++;
    }

    while (hi > 0 && arr[hi] >= arr[hi - 1]) {
        hi--;
    }

    if (lo >= hi) {
        return 0;
    }

    int result = Math.min(arr.length - lo - 1, hi);

    int i = 0, j = hi;
    while (i <= lo && j < arr.length) {
        if (arr[i] <= arr[j]) {
            result = Math.min(result, j - i - 1); 
            i++;
        } else {
            j++;
        }
    }

    return result;
}

public static boolean checkReversed(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        if (arr[i - 1] <= arr[i]) {
            return false;
        }
    }
    return true;
}

}