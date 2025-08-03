// Last updated: 3/8/2025, 11:59:12 pm
class Solution {
    public boolean isUgly(int n) {
        if(n<1)return false;
        else if(n==1)return true;
        while(n>1){
            if(n%2!=0 && n%3!=0 && n%5!=0){
                return false;
            }
            if(n%2==0)n=n/2;
            else if(n%3==0)n=n/3;
            else n=n/5;
        }
        return true;
    }
}