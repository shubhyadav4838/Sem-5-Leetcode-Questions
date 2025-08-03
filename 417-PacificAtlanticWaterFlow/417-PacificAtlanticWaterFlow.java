// Last updated: 3/8/2025, 11:58:23 pm
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        List<List<Integer>> ll = new ArrayList<>();
        char[][] ans = new char[arr.length][arr[0].length];
        // Pacific
        for(int r=0;r<arr.length;r++){
           water(arr,ans,r,0,arr[r][0],'p');
        }
        for(int c=0;c<arr[0].length;c++){
            water(arr,ans,0,c,arr[0][c],'p');
        }

        // Atlantic
        for(int r=0;r<arr.length;r++){
           water(arr,ans,r,arr[0].length-1,arr[r][arr[0].length-1],'a');
        }
        for(int c=0;c<arr[0].length;c++){
            water(arr,ans,arr.length-1,c,arr[arr.length-1][c],'a');
        }

        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr[0].length;c++){
                if(ans[r][c]=='b'){
                    ll.add(new ArrayList<>(Arrays.asList(r, c)));
                }
            }
        }
        return ll;
    }
    public static void water(int[][]arr,char[][] ans, int r, int c ,int prev, char ocean){
        if(r<0 || c<0 || r==arr.length || c==arr[0].length || arr[r][c]<prev || ans[r][c]==ocean || ans[r][c]=='b'){
            return;
        }
        if(ans[r][c]=='\0'){
            ans[r][c]=ocean;
        }else {
            ans[r][c]='b';
        }

        water(arr,ans,r+1,c,arr[r][c],ocean);
        water(arr,ans,r,c+1,arr[r][c],ocean);
        water(arr,ans,r-1,c,arr[r][c],ocean);
        water(arr,ans,r,c-1,arr[r][c],ocean);
        return;

        
    }
}