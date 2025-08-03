// Last updated: 3/8/2025, 11:52:55 pm
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        return schedule(eventTime, k, startTime, endTime);
    }
    public int schedule(int eventTime, int k, int[] stime, int[]etime){
        int[] gap = new int[stime.length+1];
        gap[0]=stime[0];
        gap[gap.length-1]=eventTime-etime[etime.length-1];
        for(int i=0;i<stime.length-1;i++){
            gap[i+1]=stime[i+1]-etime[i];
        }
        int sum=0;
        for(int i=0;i<=k;i++){
            sum+=gap[i];
        }
        int ans = sum;
        for(int i=k+1;i<gap.length;i++){
            sum+=gap[i];// window grow;
            sum-=gap[i-k-1];//window shrink;
            ans=Math.max(ans,sum);
        }
        return ans;

    }
}