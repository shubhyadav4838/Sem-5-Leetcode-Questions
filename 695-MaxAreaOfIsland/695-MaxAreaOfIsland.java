// Last updated: 3/8/2025, 11:57:01 pm
class Solution {
    public int maxAreaOfIsland(int[][] arr) {
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr[0].length;j++){
                if(arr[i][j]==1){
                    ans = Math.max(ans,island(arr,i,j,0));

                }
            }
        }
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0; j<arr[0].length;j++){
        //        System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return ans;
        
    }
    public static int island(int[][]arr ,int r,int c, int ans){
        if(r<0 || c<0 || r>=arr.length || c>=arr[0].length || arr[r][c]==0 || arr[r][c]==2){
            return 0;
        }
        arr[r][c]=2;
        int k = island(arr,r+1,c,ans+1);
        int l = island(arr,r,c+1,ans+1);
        int m = island(arr,r-1,c,ans+1);
        int n = island(arr,r,c-1,ans+1);
        return k+l+m+n+1;
        
    }
}