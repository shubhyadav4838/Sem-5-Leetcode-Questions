// Last updated: 4/8/2025, 12:01:41 am
class Solution {
     public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            if(!rowcheck(board[i])){
                return false;
            }
            if(!colcheck(i , board)){
                return false;
            }
        }
        for(int i=0;i<board.length;i+=3){
            for(int j=0;j<board[i].length;j+=3){
                if(!boxcheck(board , i , j)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean rowcheck(char arr[]){
        int num[]  = new int[10];
        for(int i=0;i<arr.length;i++){
            int val = arr[i]-'0';
            if(val>0)
            num[val]++;
        }
        for(int i : num){
            if(i>1) return false;
        }
        return true;
    }
    
    boolean colcheck(int j , char board[][]){
        int num []= new int[10];
        for(int i=0;i<board.length;i++){
            int val = board[i][j]-'0';
            if(val>0)
            num[val]++;
        }
        for(int i : num){
            if(i>1) return false;
        }
        return true;
    }

    boolean boxcheck(char board[][] , int a , int b){
        int num[] = new int[10];
         for(int i=a;i<a+3;i++){
            for(int j=b;j<b+3;j++){
                int val = board[i][j] - '0';
                if(val>0)
                num[val]++;
            }
         }
         for(int i : num){
            if(i>1)return false;
         }
         return true;
    } 
}