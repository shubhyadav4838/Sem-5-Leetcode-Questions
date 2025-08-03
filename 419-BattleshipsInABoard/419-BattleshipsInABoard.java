// Last updated: 3/8/2025, 11:58:21 pm
class Solution {
    public int countBattleships(char[][] arr) {
        int ans = 0;
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]=='X'){
                    count(arr,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void count(char[][] arr, int r, int c){
        if(r<0 || c<0 || r==arr.length || c==arr[0].length || arr[r][c]!='X'){
            return;
        }
        arr[r][c]='.';
        count(arr,r+1,c);
        count(arr,r,c+1);
        count(arr,r-1,c);
        count(arr,r,c-1);
        return;
    }
}