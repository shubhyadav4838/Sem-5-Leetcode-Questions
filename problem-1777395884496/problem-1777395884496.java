// Last updated: 28/4/2026, 10:34:44 pm
1class Solution {
2    public int minOperations(int[][] grid, int x) {
3       return uniqueValue(grid,x); 
4    }
5    public static int uniqueValue(int[][]arr, int x) {
6		int[] ans = new int[arr.length*arr[0].length];
7		int idx = 0;
8		for(int i=0;i<arr.length;i++) {
9			for(int j=0;j<arr[0].length;j++) {
10				ans[idx]=arr[i][j];
11				idx++;
12			}
13		}
14		Arrays.sort(ans);
15		int moves = 0;
16		int num = ans[ans.length/2];
17		for(int i=0;i<ans.length;i++) {
18			if(ans[i]<num) {
19				int toadd = num-ans[i];
20				if(toadd%x!=0)return -1;
21				moves+=toadd/x;
22			}else if(ans[i]>num) {
23				int toadd=ans[i]-num;
24				if(toadd%x!=0)return -1;
25				moves+=toadd/x;
26			}
27		}
28		return moves;
29	}
30}