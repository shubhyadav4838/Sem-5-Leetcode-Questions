// Last updated: 4/8/2025, 12:02:27 am
class Solution {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        float r;
        int n = num1.length;
        int m = num2.length;
        int [] result = new int [m+n];
        for (int i = 0; i<n; i++){
            result[i] = num1[i];
        }
        int i = n;
        int j = 0;
        while(j<m){
            result[i] = num2[j];
            j++;
            i++;
        }
        Arrays.sort(result);
        if((m+n)%2!=0){
        r = (float)result[(result.length-1)/2];
        }else{
        r = (result[(result.length-1)/2]+result[((result.length-1)/2)+1])/2f;
    }
    return r;
    }
}