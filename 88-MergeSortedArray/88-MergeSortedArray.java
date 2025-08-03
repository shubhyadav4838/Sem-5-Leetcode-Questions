// Last updated: 4/8/2025, 12:00:34 am
class Solution {
    public void merge(int[] n1, int m, int[] n2, int n) {
        int i=n1.length-1;
        m=m-1;n=n-1;
        while(m>=0&&n>=0){
            if(n1[m]>n2[n]){
                n1[i--]=n1[m--];
            }else{
                n1[i--]=n2[n--];
            }
        }
        while(m>=0){
            n1[i--]=n1[m--];
        }
        while(n>=0){
            n1[i--]=n2[n--];
        }
       
    }
}