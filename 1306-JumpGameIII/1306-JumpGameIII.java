// Last updated: 19/5/2026, 10:42:10 am
1class Solution {
2   public static boolean canReach(int[] arr, int start) {
3		Queue<Integer> q = new LinkedList<>();
4		boolean[] visited = new boolean[arr.length];
5		visited[start] = true;
6		
7		q.add(start);
8		while(!q.isEmpty()) {
9			int idx = q.poll();
10			if(idx<0 || idx>=arr.length )continue;
11			if(arr[idx] == 0)return true;
12			
13			int right = idx+arr[idx];
14			int left = idx-arr[idx];
15			
16			if(right <arr.length && !visited[right]) {
17				q.add(right);
18				visited[right] = true;
19			}
20			
21			if(left>=0 && !visited[left]) {
22				q.add(left);
23				visited[left] = true;
24			}
25			
26		}
27		return false;
28	}
29}