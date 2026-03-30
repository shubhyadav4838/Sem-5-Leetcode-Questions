// Last updated: 30/3/2026, 3:48:53 pm
class Solution {
    public int maximumSum(int[] arr) {
        // two options 
        // no deletion  max in no deletion plus curr and curr 
        // one delerion max in add curr to one deletion or delete curr i.e no deletion from prev index

        int nodeletion,onedeletion,ans;
        nodeletion=arr[0];
        onedeletion=Integer.MIN_VALUE;
        ans=arr[0];
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prevnodeletion=nodeletion;
            int prevonedeletion=onedeletion;

            nodeletion=Math.max(curr,prevnodeletion+curr);
            int v2;
            if(prevonedeletion==Integer.MIN_VALUE){
                v2=arr[i];
            }else{
                v2=prevonedeletion+curr;
            }

            onedeletion=Math.max(v2,prevnodeletion);

            ans=Math.max(ans,Math.max(nodeletion,onedeletion));


        }

        return ans;
    }
}