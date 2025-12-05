// Last updated: 5/12/2025, 1:59:44 pm
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        return findMedian(nums1,nums2);
4    }
5    public static double findMedian(int[] arra, int[] arrb) {
6		int a = arra.length;
7		int b = arrb.length;
8		if(a>b)return findMedian(arrb,arra);
9		
10		int lo = 0;
11		int hi = arra.length;
12		int req = (a+b+1)/2;
13		while(lo<=hi) {
14			int mid = (lo+hi)/2;
15		
16			int mid2 = req-mid-1;
17			int r1 = Integer.MAX_VALUE;
18			int r2 = Integer.MAX_VALUE;
19			int l1 = Integer.MIN_VALUE;
20			int l2 = Integer.MIN_VALUE;
21			if(mid-1>=0)l1 = arra[mid-1];
22			if(mid<a)r1 = arra[mid];
23			if(mid2+1<b)r2 = arrb[mid2+1];
24			if(mid2>=0)l2 = arrb[mid2];
25			if(l1<=r2 && l2<=r1) {
26				
27				if((a+b)%2==0) {
28					return (double)( Math.max(l1, l2) + Math.min(r1, r2) )/2.0 ;
29				}
30				
31				return Math.max(l1, l2);
32			}
33			if(l1>r2)hi = mid-1;
34			else lo = mid+1;
35			
36		}
37		return 0;
38		
39		
40	}
41}