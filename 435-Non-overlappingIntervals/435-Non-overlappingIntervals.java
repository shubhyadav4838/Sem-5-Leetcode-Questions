// Last updated: 23/3/2026, 6:44:09 pm
1class Solution {
2    public static int eraseOverlapIntervals(int[][] arr) {
3		Arrays.sort(arr,(a,b)->{
4			if(a[1]==b[1])return b[0]-a[0];
5			return a[1]-b[1];
6		});
7		
8//		for(int[] x:arr) {
9//			for(int y:x) {
10//				System.out.print(y+ " ");
11//			}
12//			System.out.println();
13//		}
14
15		int remove = 0;
16		int end = arr[0][1];
17		for(int i=1;i<arr.length;i++) {
18			if(arr[i][0]<end) {
19				remove++;
20			}else {
21				end = arr[i][1];
22			}
23		}
24		return remove;
25
26	}
27}