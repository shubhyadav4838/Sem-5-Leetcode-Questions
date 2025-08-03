// Last updated: 4/8/2025, 12:02:18 am
class Solution {
    public int maxArea(int[] height) {
        return MostWater(height);
        
    }
    public static int MostWater(int [] arr){
        // int [] area = new int[arr.length];
        int max = 0;
        int l = 0;
        int r = arr.length-1;
        // int i = 0;
        while(l<r){
            int result = 0;
            // area[i++] = result;
            if(arr[r]==arr[l]){
                result = (r-l)*arr[r];
                r--;
                l++;
            }else if(arr[r]<arr[l]){
                result = (r-l)*arr[r];
                r--;
            }else{
                result = (r-l)*arr[l];
                l++;
            }
            if(result>max){
                max = result;
            }
           
        }
        // Arrays.sort(area);
        // return area[area.length-1];
        return max;

    }
}