// Last updated: 17/4/2026, 7:28:13 pm
1class Solution {
2   public static int minMirrorPairDistance(int[] arr) {
3		HashMap<Integer,Integer> map = new HashMap<>();
4		int ans = Integer.MAX_VALUE;
5		for(int i = 0;i<arr.length; i++) {
6			int rev = getReverse(arr[i]);
7			if(map.containsKey(rev) && arr[i]%10!=0) {
8				ans = Math.min(ans, i-map.get(rev));
9			}
10			while(arr[i]%10==0) {
11				arr[i] = arr[i]/10;
12			}
13			map.put(arr[i], i);
14		}
15		return (ans==Integer.MAX_VALUE ? -1:ans);
16	}
17
18	private static int getReverse(int val) {
19		// TODO Auto-generated method stub
20		while(val%10==0) {
21			val = val/10;
22		}
23		
24		int sum = 0;
25		while(val>0) {
26			int rem = val%10;
27			val = val/10;
28			sum = sum*10+rem;
29			
30		}
31		return sum;
32	}
33
34}