// Last updated: 6/12/2025, 1:25:58 am
1class Solution {
2    public int minPatches(int[] nums, int n) {
3        return patching(nums,n);
4    }
5    public static int patching(int[] arr, int k) {
6		long sum = 0;
7		long next = 1;
8		int i=0;
9		if(arr[0]==1) {
10			sum=1;
11			i++;
12		}
13		
14		int n = arr.length;
15		int count = 0;
16		while(i<=n && sum<k) {
17			while(i<n && sum+1<arr[i]) {
18				sum+=sum+1;
19				count++;
20			}
21			while(i<n && arr[i]<=sum+1) {
22				sum+=arr[i];
23				i++;
24			}
25			if(sum>=k)break;
26			sum+=sum+1;
27			count++;
28			
29		}
30		return count;
31		
32	       
33	}
34
35}