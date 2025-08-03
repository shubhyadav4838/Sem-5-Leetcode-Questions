// Last updated: 3/8/2025, 11:53:20 pm
class Solution {
    public boolean canAliceWin(int n) {
        return RemovalGame(n);
        
    }
    public boolean RemovalGame(int n){
        if(n<10){
            return false;
        }
        if(n<19){
            return  true;
        }
        for(int i=10; i>0; i--){
            if(i%2==0){
                if(i>n){
                    return false;
                }else{
                    n-=i;
                }
            }
            else{
                if(i>n){
                    return true;
                }
                else{
                    n-=i;
                }
            }
        }
            return true;
    }
}