// Last updated: 3/8/2025, 11:55:35 pm
class Solution {
    public int numEnclaves(int[][] arr) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==0 || j==0 || i==arr.length-1 || j==arr[0].length-1){
                    remove(arr,i,j);
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
               if(arr[i][j]==1) count++;
            }
        }
        return count;
        
    }
    public static void remove(int[][]arr, int r, int c){
        if(r>=arr.length || c>=arr[0].length || r<0 || c<0 || arr[r][c]==0){
            return;
        }
        arr[r][c]=0;
        remove(arr,r+1,c);
        remove(arr,r,c+1);
        remove(arr,r-1,c);
        remove(arr,r,c-1);
    }
}