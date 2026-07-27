// Last updated: 27/7/2026, 11:42:43 am
class Solution {
    public static int earliestFinishTime(int[] lstart, int[] ldur, int[] wstart, int[] wdur) {
		int max = Integer.MAX_VALUE;
        int land = max, water = max, minl = max, minw = max;
        int n = lstart.length, m = wstart.length;
        for(int i = 0; i<n; i++){
            land = Math.min(land,lstart[i]+ldur[i]);
        }

        for(int i=0;i<m; i++){
            water = Math.min(water,wstart[i]+wdur[i]);
            minl = Math.min(minl, Math.max(land,wstart[i])+wdur[i]);
        }

        for(int i =0;i<n; i++){
            minw = Math.min(minw,Math.max(water,lstart[i])+ldur[i]);
        }

        return Math.min(minw,minl);

	}
}