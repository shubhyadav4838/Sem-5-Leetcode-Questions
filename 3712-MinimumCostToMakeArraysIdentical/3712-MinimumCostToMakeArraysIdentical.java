// Last updated: 3/8/2025, 11:53:04 pm
class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        return Cost(arr,brr,k);
    }
    public long Cost(int [] arr, int[] bra, long k){
        boolean flag = true;
        long sum = 0;
        for(int i=0;i<bra.length;i++){
            if(arr[i]!=bra[i]){
                flag = false;
            }
            sum+=Math.abs(arr[i]-bra[i]);
        }
        if(flag){
            return 0;
        }
        Arrays.sort(arr);
        Arrays.sort(bra);
        long sortsum = k;
        for(int i=0;i<bra.length;i++){
            
            sortsum+=Math.abs(arr[i]-bra[i]);
        }
        return Math.min(sum,sortsum);
        
        
    }
}