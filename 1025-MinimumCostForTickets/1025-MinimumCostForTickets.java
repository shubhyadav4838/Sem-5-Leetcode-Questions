// Last updated: 3/8/2025, 11:55:55 pm
class Solution {
    private int linearsearch(int[] days,int start,int search){
        while(start<days.length){
            if(days[start]>=search){
                return start;
            }
            start++;
        }
        return start;
    }
    private int abc(int index,int[] days, int[] costs,int[] dp){
        if(index==days.length){
            
            return 0;
        }
        else if(dp[index]!=0){
            return dp[index];
        }
        int onedaypass=costs[0]+abc(index+1,days,costs,dp);
        int index1=linearsearch(days,index,days[index]+7);
        int sevendaypass=costs[1]+abc(index1,days,costs,dp);
        int index2=linearsearch(days,index,days[index]+30);
        int thirtydaypass=costs[2]+abc(index2,days,costs,dp);
        return dp[index]=Math.min(onedaypass,Math.min(sevendaypass,thirtydaypass));
    }

    public int mincostTickets(int[] days, int[] costs) {
        return abc(0,days,costs,new int[days.length]);
        
    }
}