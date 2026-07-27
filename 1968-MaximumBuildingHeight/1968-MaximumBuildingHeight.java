// Last updated: 27/7/2026, 11:44:45 am
class Solution {
    public static int maxBuilding(int n, int[][] arr) {
        if(arr.length==0){
            return n-1;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i][1]>arr[i+1][1]){
                int dis = arr[i+1][0] -arr[i][0];
                int height = arr[i][1] - arr[i+1][1];
                if(height>dis){
                    arr[i][1] = arr[i+1][1]+dis;
                }
            }
            
        }

        int max = 0;
        max = maxHeight(0,arr[0][1],arr[0][0]-1);
        if(max<arr[0][1]){
            arr[0][1] = max;
        }
        for(int i =0;i<arr.length-1;i++){
            int res = maxHeight(arr[i][1],arr[i+1][1],arr[i+1][0]-arr[i][0]);
            max = Math.max(max,res);
            if(res<arr[i+1][1]){
                arr[i+1][1] = res;
            }
        }

        int last = maxHeight(arr[arr.length-1][1],9999999,n-arr[arr.length-1][0]);
        max = Math.max(last,max);


        return max;
    }

    public static int maxHeight(int a, int b, int diff){
        int height = Math.abs(a-b);
        if(diff<=height){
            return diff+Math.min(a,b);
        }
        int max = Math.max(a,b) + ((diff-height)/2);
        return max;

    }
}