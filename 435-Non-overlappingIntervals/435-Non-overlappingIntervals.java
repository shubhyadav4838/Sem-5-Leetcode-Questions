// Last updated: 23/3/2026, 6:44:28 pm
1class Solution {
2    public static int eraseOverlapIntervals(int[][] arr) {
3		Arrays.sort(arr,(a,b)->{
4			if(a[1]==b[1])return b[0]-a[0];
5			return a[1]-b[1];
6		});
7		
8		int remove = 0;
9		int end = arr[0][1];
10		for(int i=1;i<arr.length;i++) {
11			if(arr[i][0]<end) {
12				remove++;
13			}else {
14				end = arr[i][1];
15			}
16		}
17		return remove;
18
19	}
20}