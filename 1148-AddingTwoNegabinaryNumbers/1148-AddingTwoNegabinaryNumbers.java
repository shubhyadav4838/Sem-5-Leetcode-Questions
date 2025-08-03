// Last updated: 3/8/2025, 11:55:26 pm
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int carry = 0;
        int i = n - 1, j = m - 1;
        while(i >= 0 && j >= 0) {
            int val = arr1[i] + arr2[j] + carry;
            int digit = 0;
            if (val < 0) {
                carry = 1;
                digit = 1;
            } 
            else {
                carry = -(val / 2);
                digit = val % 2;
            }
            list.add(0, digit);
            --i;
            --j;
        }
        while(i >= 0) {
            int val = arr1[i] + carry;
            int digit = 0;
            if (val < 0) {
                carry = 1;
                digit = 1;
            } 
            else {
                carry = -(val / 2);
                digit = val % 2;
            }
            list.add(0, digit);
            --i;
        }
        while(j >= 0) {
            int val = arr2[j] + carry;
            int digit = 0;
            if (val < 0) {
                carry = 1;
                digit = 1;
            } 
            else {
                carry = -(val / 2);
                digit = val % 2;
            }
            list.add(0, digit);
            --j;
        }
        if (carry == -1) {
            list.add(0, 1);
            list.add(0, 1);
        }  
        
        while(list.size() > 1 && list.get(0) == 0) {
            list.remove(0);
        }
        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); ++k) {
            ans[k] = list.get(k);
        }
        return ans;
    }
}