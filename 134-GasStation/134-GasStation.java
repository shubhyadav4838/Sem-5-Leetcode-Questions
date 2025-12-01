// Last updated: 2/12/2025, 1:18:09 am
1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        return canComplete(gas,cost);
4        
5    }
6    public static int canComplete(int[]gas, int[]cost) {
7		int total = 0;
8		for (int i= 0; i<cost.length; i++) {
9			total += gas[i] - cost[i];
10		}
11		if(total<0) {
12			return -1;
13		}
14		int idx = 0;
15		int curr = 0;
16		for(int i=0; i<cost.length; i++) {
17			curr+= gas[i]-cost[i];
18			if(curr<0) {
19				curr = 0;
20				idx = i+1;
21			}
22			
23		}
24		return idx;
25	}
26}