// Last updated: 3/8/2025, 11:57:22 pm
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[]arr = new int[6];
        arr[0] = dis(p1,p2);
        arr[1] = dis(p1,p3);
        arr[2] = dis(p1,p4);
        arr[3] = dis(p2,p3);
        arr[4] = dis(p2,p4);
        arr[5] = dis(p3,p4);
        Arrays.sort(arr);
        for(int x:arr){
            if(x==0)return false;
        }
        if(arr[0]==arr[1] && arr[0]==arr[2] && arr[0]==arr[3] && arr[4]==arr[5] )return true;
        return false;
        
    }
    public int dis(int[] a, int[] b){
       
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
}