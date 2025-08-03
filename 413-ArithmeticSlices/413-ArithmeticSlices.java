// Last updated: 3/8/2025, 11:58:25 pm
class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        if(arr.length < 3) return 0;

        int d = arr[1]-arr[0];
        int c = 2,p=1,ans=0;
        for(int i = 2;i<arr.length;i++){
            c++;
            if(d==(arr[i]-arr[i-1]) && c>2){
                ans+=p++;
            }else{
                d=arr[i]-arr[i-1];
                c=2;
                p=1;
            }
        }
        return ans;
    }
}