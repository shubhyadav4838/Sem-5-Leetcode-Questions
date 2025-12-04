// Last updated: 4/12/2025, 10:53:18 pm
1class Solution {
2    public int search(int[] nums, int target) {
3        return solve(nums,target);
4    }
5    public static int solve(int[] arr, int target){
6        int ans = -1;
7        int lo = 0;
8        int hi = arr.length-1;
9        while(lo<=hi){
10            int mid = (lo+hi)/2;
11            if(arr[mid]==target){
12                return mid;
13            }
14            if(arr[mid]<arr[hi] && arr[mid]<target && target<=arr[hi]){
15                lo = mid+1;
16            }else if(arr[mid]>arr[hi] && target<=arr[hi] && target<=arr[mid]) {
17                lo = mid+1;
18            }else if( arr[mid]>arr[hi] && target>=arr[hi] && target>=arr[mid] ) {
19                lo = mid+1;
20            }else{
21                hi = mid-1;
22            }
23        }
24        return ans;
25    }
26}