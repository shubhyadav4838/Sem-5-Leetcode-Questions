// Last updated: 3/8/2025, 11:58:45 pm
class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x<y){
            int t=x;
            x=y;
            y=t;
        }
        if(target==x+y || target ==x || target == y)return true;
        if(target>x+y)return false;
        if(x-y==1 || y-x==1) return true;
        if(x%2==0 && y%2==0 && target%2!=0)return false;
        if(x%2==0 && y%2==0 && target%y==0)return true;
        if(x%2!=0 && y%2!=0 && (x%y!=0))return true;
        if(x%2!=0 && y%2!=0 && (target%y==0 ))return true;
        if((x%2==0 && y%2!=0) || (x%2!=0 && y%2==0)){
            int k = findGCD(x,y);
            if(k==1)return true;
            return false;
        }
        
    return false;
    }
     public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}