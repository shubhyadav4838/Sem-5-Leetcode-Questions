// Last updated: 27/7/2026, 11:46:18 am
class Solution {
    public int longestStrChain(String[] arr) {
        int n = arr.length;
        Arrays.sort(arr,(a,b)->a.length()-b.length());
        int[] dp = new int[n];

        Arrays.fill(dp,1);
        int maxlen = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(ispossible(arr[j],arr[i]) && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }

                maxlen = Math.max(maxlen,dp[i]);
            }
        }
        return maxlen;
    }

    public static boolean ispossible(String a, String b){
        int n = a.length();
        int m = b.length();
        if(n+1 != m)return false;
        int idxa = 0;
        int idxb = 0;
        int count = 0;
        while(idxa<n && idxb<m){
            if(a.charAt(idxa)==b.charAt(idxb)){
                idxa++;
                idxb++;
                count++;
            }else{
                idxb++;
            }
        }
        return count==n;
        
    }
}