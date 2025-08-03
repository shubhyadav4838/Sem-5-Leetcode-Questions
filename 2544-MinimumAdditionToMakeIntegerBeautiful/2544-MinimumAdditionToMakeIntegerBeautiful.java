// Last updated: 3/8/2025, 11:53:54 pm
class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        int d = 0;
        long sumD = 0;
        long temp = n;
        while(temp>0){
            sumD+=temp%10;
            d++;
            temp/=10;
        }
        if(sumD<=target) return 0;
        temp = n;
        long ans = 0;
        for(int i = 1; i <= d; i++){
            long t = (long)(Math.pow(10,i)-(temp % Math.pow(10,i)));
            ans = SumOfD(n+t);
            if(ans<=target) return t;
        }
        return 0;
    }
    public long SumOfD(long temp){
        long sumD = 0;
        while(temp>0){
            sumD+=temp%10;
            temp/=10;
        }
        return sumD;
    }
}